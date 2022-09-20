package com.example.week4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "/Cashier.php")
public class CashierView extends VerticalLayout {
    private TextField cashthrone, cash1000, cash500, cash100, cash20, cash10, cash5, cash1;
    private Button btn;
    private Change refund;

    public CashierView(){
        cashthrone = new TextField();
        cash1000 = new TextField();
        cash500 = new TextField();
        cash100 = new TextField();
        cash20 = new TextField();
        cash10 = new TextField();
        cash5 = new TextField();
        cash1 = new TextField();
        btn = new Button("คำนวณถอนเงิน");
        cashthrone.setPrefixComponent(new Span("$"));
        cash1000.setPrefixComponent(new Span("$1000:"));
        cash500.setPrefixComponent(new Span("$500:"));
        cash100.setPrefixComponent(new Span("$100:"));
        cash20.setPrefixComponent(new Span("$20:"));
        cash10.setPrefixComponent(new Span("$10:"));
        cash5.setPrefixComponent(new Span("$5:"));
        cash1.setPrefixComponent(new Span("$1:"));
        this.add(cashthrone, btn, cash1000, cash500, cash100, cash20, cash10, cash5, cash1);

        btn.addClickListener(event -> {
            int n = Integer.parseInt(cashthrone.getValue());

            refund = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/getChange/"+n)
                    .retrieve()
                    .bodyToMono(Change.class)
                    .block();

            setView();
        });

    }


    public void setView() {
        cash1000.setValue(refund.getB1000()+"");
        cash500.setValue(refund.getB500()+"");
        cash100.setValue(refund.getB100()+"");
        cash20.setValue(refund.getB20()+"");
        cash10.setValue(refund.getB10()+"");
        cash5.setValue(refund.getB5()+"");
        cash1.setValue(refund.getB1()+"");
    }
}
