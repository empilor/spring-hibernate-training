package com.luv2code.springdemo;

import static com.luv2code.springdemo.LoggerHelper.buildLog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class SayingFortuneService implements FortuneService {

	private String filePath = "C:\\Users\\Vadim_Zelenin\\EclipseWorkspace\\spring-com.luv2code.springsecurity.demo-annotations\\src\\";
	private String filePackage = "com\\com.luv2code\\springdemo\\";
	private String fileName = "fortunes.txt";
	private List<String> fortunes;
	private Random random;

	public SayingFortuneService() {
	}

//	public SayingFortuneService(@Value("#{'${edu.fortune.values}'.split(';')}") String[] fortunes) {
//		this.fortunes = fortunes;
//	}

	@PostConstruct
	public void readFortunes() throws IOException {
		System.out.println(buildMessage("inside post-construct method - read fortunes from text file"));
		fortunes = new ArrayList<>();
		File file = new File(filePath + filePackage + fileName);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String lineSeparator = System.getProperty("line.separator");
		String line = br.readLine();

		while ((line = br.readLine()) != null) {
			fortunes.add(line);
		}
	}

	@Override
	public String getFortune() {
		random = new Random();
		int index = random.nextInt(fortunes.size());
		String thisFortune = fortunes.get(index);
		return thisFortune;
	}

	private String buildMessage(String inputString) {
		return buildLog(this, inputString);
	}
}
