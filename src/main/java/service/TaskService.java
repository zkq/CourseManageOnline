package service;

import entity.Task;
import org.springframework.ui.ModelMap;

/**
 * Created by Flyme on 2017/1/25.
 */
public interface TaskService {
    boolean getAllByCid(ModelMap model, String cid);

    boolean delete(ModelMap model, String id);

    boolean getWorkList(ModelMap model, String id);

    boolean newEdit(ModelMap model, String cid);

    boolean oldEdit(ModelMap model, String id);

    boolean add(ModelMap model, Task task);
}
