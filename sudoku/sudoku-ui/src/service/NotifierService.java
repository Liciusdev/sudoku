package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static service.eventEnum.CLEAR_SPACE;

public class NotifierService {

    private final Map<eventEnum, List<eventListener>> listeners = new HashMap<>(){{
        put(CLEAR_SPACE, new ArrayList<>());
    }};

    public void subscribe(final eventEnum eventType, eventListener listener){
        var selectedListeners = listeners.get(eventType);
        selectedListeners.add(listener);
    }

    public void notify(final eventEnum eventType){
        listeners.get(eventType).forEach(l -> l.update(eventType));
    }

}