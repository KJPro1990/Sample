package jp.co.test.sample.common;

import java.time.LocalDateTime;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public final class SystemErrorController {

	// TODO Exceptionの種類で振り分ける
	@ExceptionHandler(value = Exception.class)
	public String handleError(Model model, Exception ex) {
		model.addAttribute("datetime", LocalDateTime.now());
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("exception", ex.getClass());
		model.addAttribute("cause", ex.getCause());
		model.addAttribute("class", model.getClass());
		return "/error";
	}
}
