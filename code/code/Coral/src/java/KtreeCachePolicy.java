
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("unchecked")
public class KtreeCachePolicy implements CachePolicy {

  protected Map m_map;

  
  protected LRUList m_list;

  protected int m_maxCapacity;

  
  protected int m_minCapacity;


  public KtreeCachePolicy() {
  }

  
  public KtreeCachePolicy(int min, int max) {
    if (min < 2 || min > max) {
      throw new IllegalArgumentException("Illegal cache capacities");
    }
    m_minCapacity = min;
    m_maxCapacity = max;
  }


  protected Map createMap() {
    return new HashMap();
  }


  public void create() {
    m_map = createMap();
    m_list = createList();
    m_list.m_maxCapacity = m_maxCapacity;
    m_list.m_minCapacity = m_minCapacity;
    m_list.m_capacity = m_maxCapacity;
  }


  public void start() {
  }

  public void stop() {
    if (m_list != null) {
      flush();
    }
  }

 
  public void destroy() {
    if (m_map != null)
      m_map.clear();
    if (m_list != null)
      m_list.clear();
  }

  public Object get(Object key) {
    if (key == null) {
      throw new IllegalArgumentException("Requesting an object using a null key");
    }

    LRUCacheEntry value = (LRUCacheEntry) m_map.get(key);
    if (value != null) {
      m_list.promote(value);
      return value.m_object;
    } else {
      cacheMiss();
      return null;
    }
  }

  public Object peek(Object key) {
    if (key == null) {
      throw new IllegalArgumentException("Requesting an object using a null key");
    }

    LRUCacheEntry value = (LRUCacheEntry) m_map.get(key);
    if (value == null) {
      return null;
    } else {
      return value.m_object;
    }
  }

  public void insert(Object key, Object o) {
    if (o == null) {
      throw new IllegalArgumentException("Cannot insert a null object in the cache");
    }
    if (key == null) {
      throw new IllegalArgumentException("Cannot insert an object in the cache with null key");
    }
    if (m_map.containsKey(key)) {
      throw new IllegalStateException("Attempt to put in the cache an object that is already there");
    }
    m_list.demote();
    LRUCacheEntry entry = createCacheEntry(key, o);
    m_map.put(key, entry);
    m_list.promote(entry);
  }

  public void remove(Object key) {
    if (key == null) {
      throw new IllegalArgumentException("Removing an object using a null key");
    }

    Object value = m_map.remove(key);
    if (value != null) {
      m_list.remove((LRUCacheEntry) value);
    }
    
  }

  public void flush() {
    LRUCacheEntry entry = null;
    while ((entry = m_list.m_tail) != null) {
      ageOut(entry);
    }
  }

  public int size() {
    return m_list.m_count;
  }


  protected LRUList createList() {
    return new LRUList();
  }

  protected void ageOut(LRUCacheEntry entry) {
    remove(entry.m_key);
  }

  protected void cacheMiss() {
  }

 
  protected LRUCacheEntry createCacheEntry(Object key, Object value) {
    return new LRUCacheEntry(key, value);
  }

  
  public class LRUList {
    
    @SuppressWarnings("hiding")
    public int m_maxCapacity;

    
    @SuppressWarnings("hiding")
    public int m_minCapacity;

   
    public int m_capacity;

   
    public int m_count;


    public LRUCacheEntry m_head;

   
    public LRUCacheEntry m_tail;

    
    public int m_cacheMiss;

    
    protected LRUList() {
      m_head = null;
      m_tail = null;
      m_count = 0;
    }

    
    protected void promote(LRUCacheEntry entry) {
      if (entry == null) {
        throw new IllegalArgumentException("Trying to promote a null object");
      }
      if (m_capacity < 1) {
        throw new IllegalStateException("Can't work with capacity < 1");
      }

      entryPromotion(entry);

      entry.m_time = System.currentTimeMillis();
      if (entry.m_prev == null) {
        if (entry.m_next == null) {
         
          if (m_count == 0) 
          {
            m_head = entry;
            m_tail = entry;
            ++m_count;
            entryAdded(entry);
          } else if (m_count == 1 && m_head == entry) {
          } 
          else if (m_count < m_capacity) {
            entry.m_prev = null;
            entry.m_next = m_head;
            m_head.m_prev = entry;
            m_head = entry;
            ++m_count;
            entryAdded(entry);
          } else if (m_count < m_maxCapacity) {
            entry.m_prev = null;
            entry.m_next = m_head;
            m_head.m_prev = entry;
            m_head = entry;
            ++m_count;
            int oldCapacity = m_capacity;
            ++m_capacity;
            entryAdded(entry);
            capacityChanged(oldCapacity);
          } else {
            throw new IllegalStateException("Attempt to put a new cache entry on a full cache");
          }
        } else {
        } 
      } else {
        if (entry.m_next == null) 
        {
          LRUCacheEntry beforeLast = entry.m_prev;
          beforeLast.m_next = null;
          entry.m_prev = null;
          entry.m_next = m_head;
          m_head.m_prev = entry;
          m_head = entry;
          m_tail = beforeLast;
        } else 
        {
          LRUCacheEntry previous = entry.m_prev;
          previous.m_next = entry.m_next;
          entry.m_next.m_prev = previous;
          entry.m_prev = null;
          entry.m_next = m_head;
          m_head.m_prev = entry;
          m_head = entry;
        }
      }
    }

    
    protected void demote() {
      if (m_capacity < 1) {
        throw new IllegalStateException("Can't work with capacity < 1");
      }
      if (m_count > m_maxCapacity) {
        throw new IllegalStateException("Cache list entries number (" + m_count
            + ") > than the maximum allowed (" + m_maxCapacity + ")");
      }
      if (m_count == m_maxCapacity) {
        LRUCacheEntry entry = m_tail;

        
        ageOut(entry);
      } else {
      } 
    }

  
    protected void remove(LRUCacheEntry entry) {
      if (entry == null) {
        throw new IllegalArgumentException("Cannot remove a null entry from the cache");
      }
      if (m_count < 1) {
        throw new IllegalStateException("Trying to remove an entry from an empty cache");
      }

      entry.m_key = entry.m_object = null;
      if (m_count == 1) {
        m_head = m_tail = null;
      } else {
        if (entry.m_prev == null) // the head
        {
          m_head = entry.m_next;
          m_head.m_prev = null;
          entry.m_next = null;
        } else if (entry.m_next == null) // the tail
        {
          m_tail = entry.m_prev;
          m_tail.m_next = null;
          entry.m_prev = null;
        } else // in the middle
        {
          entry.m_next.m_prev = entry.m_prev;
          entry.m_prev.m_next = entry.m_next;
          entry.m_prev = null;
          entry.m_next = null;
        }
      }
      --m_count;
      entryRemoved(entry);
    }

    
    protected void entryPromotion(LRUCacheEntry entry) {
    }

    
    protected void entryAdded(LRUCacheEntry entry) {
    }

   
    protected void entryRemoved(LRUCacheEntry entry) {
    }

   
    protected void capacityChanged(int oldCapacity) {
    }

    protected void clear() {
      LRUCacheEntry entry = m_head;
      m_head = null;
      m_tail = null;
      m_count = 0;
      for (; entry != null; entry = entry.m_next)
        entryRemoved(entry);
    }

    public String toString() {
      String s = Integer.toHexString(super.hashCode());
      s += " size: " + m_count;
      for (LRUCacheEntry entry = m_head; entry != null; entry = entry.m_next) {
        s += "\n" + entry;
      }
      return s;
    }
  }

  
  public class LRUCacheEntry {
    /** Reference to the next cell in the list */
    public LRUCacheEntry m_next;

    /** Reference to the previous cell in the list */
    public LRUCacheEntry m_prev;

    /** The key used to retrieve the cached object */
    public Object m_key;

    /** The cached object */
    public Object m_object;

    /** The timestamp of the creation */
    public long m_time;

    
    
    protected LRUCacheEntry(Object key, Object object) {
      m_key = key;
      m_object = object;
      m_next = null;
      m_prev = null;
      m_time = 0; 
    }

    public String toString() {
      return "key: " + m_key + ", object: "
          + (m_object == null ? "null" : Integer.toHexString(m_object.hashCode())) + ", entry: "
          + Integer.toHexString(super.hashCode());
    }
  }
}


interface CachePolicy {
  
  Object get(Object key);

  Object peek(Object key);


  void insert(Object key, Object object);

 
  void remove(Object key);

 
  void flush();

  
  int size();

  void create() throws Exception;

  void start() throws Exception;

  void stop();

  void destroy();
}
