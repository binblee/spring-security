package binblee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by libin on 15/7/18.
 */

@RestController
@RequestMapping("/")
public class ResourceController {

    @RequestMapping(method = RequestMethod.GET)
    public Map<String,Object> home(){
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World !!!");
        return model;
    }
}
