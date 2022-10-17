package com.example.demo.jp.co.demo.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RestController
//@RequestMapping("api/sample")
public class SampleRestController {

//    @RequestMapping("/")       // URLのパスの指定
//    @ResponseBody
//    public List<String> top(@RequestParam(value = "name", required = false) String name) { // リクエストを受け付けるメソッド
//        List<String> list = new ArrayList<String>();
//        list.add("SpringBootの最小アプリケーション");
//        if (name == "hoge") {
//            list.add("(パラメータにhoge指定)");
//        } else {
//            list.add("(パラメータ指定無し)");
//        }
//        return list;
//    }

//	private final SampleService service;

	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("sampleResource", new SampleResource());
		return "index";
	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String result(@ModelAttribute SampleResource sampleResource, Model model) {
		sampleResource.setContent("おーい");
		model.addAttribute("sampleResource", sampleResource);
		return "result";
	}

//	@Autowired
//	public SampleRestController(SampleService service) {
//		this.service = service;
//	}
//
//	@GetMapping
//	public List<SampleResource> getList(SampleResource resource) {
//		return service.findList(resource);
//	}
//
//	@GetMapping("{id}")
//	public SampleResource getSample(@PathVariable("id") int id) throws NotFoundException {
//		return service.findById(id);
//	}
//
//	@PostMapping
//	public int insert(@RequestBody @Validated SampleResource resource) {
//		return service.insert(resource);
//	}
//
//	@PutMapping
//	public int update(@RequestBody @Validated SampleResource resource) {
//		return service.update(resource);
//	}
//
//	@DeleteMapping("{id}")
//	public int delete(@PathVariable("id") int id) {
//		return service.delete(id);
//	}
}
