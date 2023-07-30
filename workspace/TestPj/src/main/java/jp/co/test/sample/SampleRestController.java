package jp.co.test.sample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SampleRestController {

	private final SampleService service;

	@RequestMapping("/index")
	public String index(Model model, SampleResource sampleResource) {
		try {
			service.findById(0);
		} catch (NotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		model.addAttribute("sampleResource", new SampleResource());
		return "index";
	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String result(@ModelAttribute SampleResource sampleResource, Model model) {
		model.addAttribute("formInfo", service.generateFormInfo());
		model.addAttribute("gridInfo", service.generateGridInfo());
		return "result";
	}

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
