package com.san.my.framework;

public class SessionContainerHolder
{
    private static final ThreadLocal<SessionContainer> sessionContainerThreadLocal = new ThreadLocal<SessionContainer>();
    
    public static void setSessionContainerToThreadContext(SessionContainer sessionContainer){
        sessionContainerThreadLocal.set(sessionContainer);
    }
    
    private static SessionContainer getSessionContainerToThreadContext(){
        return (SessionContainer)sessionContainerThreadLocal.get();
    }
    
    public static void setAttribute(String name, Object value){
        getSessionContainerToThreadContext().setAttribute(name, value);
    }
    
    public static Object getAttribute(String name){
        return getSessionContainerToThreadContext().getAttribute(name);
    }
    
    public static void removeAttribute(String name){
        getSessionContainerToThreadContext().removeAttribute(name);
    }

}
