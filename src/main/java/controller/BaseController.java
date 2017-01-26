package controller;

import org.springframework.ui.ModelMap;
import util.Names;

/**
 * Created by Flyme on 2017/1/25.
 */
public class BaseController {

    protected String responseBodyWrite(boolean res, ModelMap model){
        if(res){
            return "";
        }else{
            Object msg = model.get(Names.ERR_TAG);
            return msg == null ? "" : msg.toString();
        }
    }

}
