package zjt.learn.flowableui.controller;

import org.flowable.ui.modeler.domain.Model;
import org.flowable.ui.modeler.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 功能：
 *
 * @Author: zhaojiatao
 * @Date: 2022/7/31 21:36
 * @ClassName: TestController
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ModelRepository modelRepository;

    @GetMapping(value = "/{formKey}", produces = "application/json")
    public String getForm(@PathVariable String formKey) {

        List<Model> byKeyAndType = modelRepository.findByKeyAndType(formKey, 2);
        String modelEditorJson = byKeyAndType.get(0).getModelEditorJson();
        return modelEditorJson;
    }
}
