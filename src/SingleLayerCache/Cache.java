//package SingleLayerCache;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Cache<Key , Value> {
//
//
//    private int capacity ;
//    private Map<Key  , Value> storgae;
//
//
//
//    public Cache(int capacity) {
//        this.capacity = capacity;
//        storgae = new HashMap<>();
//    }
//
//
//    public void add(Key key, Value value) {
//        if(storgae.size()==capacity){
//            removetheKey();
//        }
//        updateCacheKeyIsAccessed();
//        storgae.put(key, value);
//    }
//
//    public Value get(Key key){
//        if(!storgae.containsKey(key)){
//            return null ;
//        }
//        updateCacheKeyIsAccessed();
//        return storgae.get( key );
//    }
//
//
//
//}
