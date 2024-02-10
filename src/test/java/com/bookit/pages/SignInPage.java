package com.bookit.pages;

import com.bookit.utilities.Driver;
import com.bookit.utilities.Environment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	public SignInPage() {
		PageFactory.initElements(Driver.get(), this);
	}

	@FindBy(name = "email")
	public WebElement email;

	@FindBy(name = "password")
	public WebElement password;

	@FindBy(xpath = "//button[.='sign in']")
	public WebElement signInButton;

	//Roles: teacher, team-member, team-leader
	public void login(String role) {
		//switch,if make sure you get correct user info

		String email, pass;

		switch (role) {

			case "teacher":
				email = Environment.TEACHER_EMAIL;
				pass = Environment.TEACHER_PASSWORD;
				break;
			case "student-member":
				email = Environment.MEMBER_EMAIL;
				pass = Environment.MEMBER_PASSWORD;
				break;

			case "student-leader":
				email = Environment.LEADER_EMAIL;
				pass = Environment.LEADER_PASSWORD;
				break;

			default:
				throw new IllegalStateException("Unexpected value: " + role);
		}

		this.email.sendKeys(email);
		this.password.sendKeys(pass);
		signInButton.click();

	}
}
