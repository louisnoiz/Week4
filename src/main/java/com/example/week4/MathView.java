package com.example.week4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;


@Route (value = "/calPage.php")
public class MathView extends VerticalLayout {
    private TextField num1, num2;
    private TextField answer;

    private Button plus, minus, multi, divide, mod, max;
    public MathView(){
        num1 = new TextField();
        num2 = new TextField();
        answer = new TextField();
        plus = new Button("+");
        minus = new Button("-");
        multi = new Button("*");
        divide = new Button("/");
        mod = new Button("Mod");
        max = new Button("Max");

        HorizontalLayout actbtn = new HorizontalLayout();
        actbtn.add(plus, minus, multi, divide, mod, max);
        num1.setLabel("Number1");
        num2.setLabel("Number2");
        answer.setLabel("Answer");
        this.add(num1, num2, actbtn, answer);

        plus.addClickListener(event ->{
            double n1 = Double.parseDouble(num1.getValue());
            double n2 = Double.parseDouble(num2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/myPlus/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            answer.setValue(out);

        });

        minus.addClickListener(event ->{
            double n1 = Double.parseDouble(num1.getValue());
            double n2 = Double.parseDouble(num2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/myMinus/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            answer.setValue(out);

        });

        multi.addClickListener(event ->{
            double n1 = Double.parseDouble(num1.getValue());
            double n2 = Double.parseDouble(num2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/myMulti/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            answer.setValue(out);

        });

        divide.addClickListener(event ->{
            double n1 = Double.parseDouble(num1.getValue());
            double n2 = Double.parseDouble(num2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/myDivide/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            answer.setValue(out);

        });

        mod.addClickListener(event ->{
            double n1 = Double.parseDouble(num1.getValue());
            double n2 = Double.parseDouble(num2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/myMod/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            answer.setValue(out);

        });

        max.addClickListener(event ->{
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("num1", num1.getValue());
            formData.add("num2", num2.getValue());

            String out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/myMax")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            answer.setValue(out);
        });
    }

}
