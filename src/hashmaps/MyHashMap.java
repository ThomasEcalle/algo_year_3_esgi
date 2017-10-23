package hashmaps;

import java.util.LinkedList;

/**
 * Created by Thomas Ecalle on 02/05/2017.
 */
public class MyHashMap<K, V>
{
    class HashMapItem<K, V>
    {
        public K key;
        public V value;

        HashMapItem(K key, V value)
        {
            this.key = key;
            this.value = value;
        }


        @Override
        public boolean equals(Object obj)
        {
            if (obj instanceof HashMapItem)
            {
                HashMapItem<K, V> other = (HashMapItem<K, V>) obj;
                return other.key.equals(key);
            } else throw new RuntimeException("Not the same object");
        }
    }

    private int size = 2048;
    private LinkedList<HashMapItem<K, V>>[] buckets = new LinkedList[size];

    public V put(K key, V value)
    {
        // Modulo size pour être sûre qu'il soit à l'intérieur du tableau (pas  trop grand)
        final int hash = key.hashCode();
        final int position = hash % size;

        HashMapItem<K, V> item = new HashMapItem<>(key, value);
        LinkedList<HashMapItem<K, V>> bucket = buckets[position];
        if (bucket == null)
        {
            bucket = new LinkedList<>();
            bucket.addLast(item);
            buckets[position] = bucket;
        } else
        {
            final int index = bucket.indexOf(item);
            if (index != -1)
            {
                HashMapItem<K, V> oldItem = bucket.get(index);
                oldItem.value = item.value;
            } else
            {
                bucket.addLast(item);
            }
        }

        return value;
    }

    public V get(K key)
    {
        final HashMapItem<K, V> item = getItem(key);
        return item != null ? item.value : null;
    }

    public boolean containskey(K key)
    {
        HashMapItem<K, V> item = getItem(key);
        return item != null;
    }

    private HashMapItem<K, V> getItem(K key)
    {
        int hash = key.hashCode();
        int position = hash % size;

        LinkedList<HashMapItem<K, V>> list = buckets[position];

        if (list != null)
        {
            HashMapItem<K, V> item = new HashMapItem<>(key, null);
            int index = list.indexOf(item);
            if (index != -1)
            {
                return list.get(index);
            }
        }
        return null;
    }

    public V remove(K key)
    {
        final HashMapItem<K, V> item = getItem(key);
        if (item == null) return null;

        final int position = key.hashCode() % size;
        final V value = item.value;


        buckets[position].remove(buckets[position].indexOf(item));

        return value;
    }
}
