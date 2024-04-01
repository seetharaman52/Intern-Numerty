package com.ideapad.my_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

@Controller
public class AppController {

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculateBill(@RequestParam("customerName") String customerName,
                                @RequestParam("customerId") String customerId,
                                @RequestParam("consumption") double consumptionKwh,
                                @RequestParam("tariff") double tariffRatesPerKwh,
                                @RequestParam("fixedCharges") double fixedCharges,
                                @RequestParam("address") String address,
                                @RequestParam("email") String email,
                                @RequestParam("date") String date,
                                @RequestParam("mobileNo") String number,
                                Model model) {

        // Validate input
        if (consumptionKwh < 0 || tariffRatesPerKwh < 0 || fixedCharges < 0) {
            return "error";
        }

        // Constants
        final double TAX_RATE = 0.05;  // 5% tax rate

        // Calculate bill
        double totalCost = consumptionKwh * tariffRatesPerKwh + fixedCharges;
        double totalCostWithTaxes = totalCost * (1 + TAX_RATE);

        System.out.println("\nElectricity Bill for " + customerName + " (ID: " + customerId + ")");
        System.out.println("Address: " + address);
        System.out.println("Consumption: " + consumptionKwh + " kWh");
        System.out.println("Tariff Rates: $" + tariffRatesPerKwh + " per kWh");
        System.out.println("Fixed Charges: $" + fixedCharges);
        System.out.println("Total Cost: $" + String.format("%.2f", totalCost));
        System.out.println("Tax (" + (TAX_RATE * 100) + "%): $" + String.format("%.2f", (totalCostWithTaxes - totalCost)));
        System.out.println("Total Cost with Taxes: $" + String.format("%.2f", totalCostWithTaxes));

        model.addAttribute("customerName", customerName);
        model.addAttribute("customerId", customerId);
        model.addAttribute("consumption", consumptionKwh);
        model.addAttribute("tariff", tariffRatesPerKwh);
        model.addAttribute("fixedCharges", fixedCharges);
        model.addAttribute("address", address);
        model.addAttribute("email", email);
        model.addAttribute("date", date);
        model.addAttribute("mobileNo", number);
        model.addAttribute("pricePay", String.format("%.2f", totalCostWithTaxes));

        return "success";
    }
}
