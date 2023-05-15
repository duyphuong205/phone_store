package com.phone.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.phone.entity.User;
import com.phone.service.FileService;
import com.phone.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AccountController {

	private final UserService userService;

	private final FileService fileService;

	@GetMapping("/register")
	public String doShowRegister(Model model) {
		model.addAttribute("userRequest", new User());
		return "/user/register";
	}

	@PostMapping("/register")
	public String doRegister(@Valid @ModelAttribute("userRequest") User userRequest, Errors errros, Model model,
			@RequestParam("fileImage") MultipartFile fileImage) {
		try {
			if (errros.hasErrors()) {
				return "/user/register";
			} else {
				String imageUrl = "";
				if (fileImage.getSize() == 0 || fileImage == null || fileImage.isEmpty()) {
					imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/User-avatar.svg/2048px-User-avatar.svg.png";
				} else {
					imageUrl = fileService.uploadFile(fileImage);
				}
				if (userService.getByUsername(userRequest.getUsername()) != null) {
					model.addAttribute("existsUsername", "Tên người dùng đã tồn tại!");
					return "/user/register";
				}
				if (userService.getByEmail(userRequest.getEmail()) != null) {
					model.addAttribute("existsEmail", "Email người dùng đã tồn tại!");
					return "/user/register";
				}
				userRequest.setAvatarUrl(imageUrl);
				userService.register(userRequest);
				return "redirect:/login";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return "/user/register";
		}
	}

}
