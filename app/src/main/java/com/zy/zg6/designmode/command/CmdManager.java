package com.zy.zg6.designmode.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:zhangyue
 * @date:2021/4/2
 */
public class CmdManager {
    private List<IJSCmd> cmds=new ArrayList<>();

    public void addCmd(IJSCmd cmd){
        cmds.add(cmd);
    }

    public void executeCmd(IJSCmd cmd,int a,int b){
        cmd.js(a,b);
    }

    public void executeCmds(int a,int b){
        for (IJSCmd cmd:cmds){
            cmd.js(a,b);
        }

        cmds.clear();
    }
}
