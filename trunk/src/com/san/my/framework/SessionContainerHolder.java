package com.san.my.framework;

public class SessionContainerHolder
{
    private static final ThreadLocal<SessionContainer> sessionContainerThreadLocal = new ThreadLocal<SessionContainer>();
    
    public static void setSessionContainerToThreadContext(SessionContainer sessionContainer){
        sessionContainerThreadLocal.set(sessionContainer);
    }
    
    private static SessionContainer getSessionContainerFromThreadContext(){
        return (SessionContainer)sessionContainerThreadLocal.get();
    }
    
    public static void setAttribute(String name, Object value){
    	getSessionContainerFromThreadContext().setAttribute(name, value);
    }
    
    public static Object getAttribute(String name){
        return getSessionContainerFromThreadContext().getAttribute(name);
    }
    
    public static void removeAttribute(String name){
    	getSessionContainerFromThreadContext().removeAttribute(name);
    }

}
