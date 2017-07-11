package com.fr.lottery.dwr;


import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;

import java.util.Collection;

/**
 * @author dengbojing
 * @date 2015-11-23
 * @description
 */
@RemoteProxy(name="serverPush")
public class ServerPush {

    @RemoteMethod
    public void publish(final String content){
        Runnable run = new Runnable(){
            private ScriptBuffer script = new ScriptBuffer();
            public void run() {
                //设置要调用的 js及参数
                script.appendCall("sayHellow" , content);
                //得到所有ScriptSession
                Collection<ScriptSession> sessions = Browser.getTargetSessions();
                //遍历每一个ScriptSession
                for (ScriptSession scriptSession : sessions){
                    scriptSession.addScript( script);
                }
            }
        };
        //执行推送
        Browser. withAllSessions(run);
    }

    @RemoteMethod
    public void send(final String content,String userAccount){

    }



}