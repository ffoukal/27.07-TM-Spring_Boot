package com.romanos;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class NumerosRomanosController {

    @GetMapping(path = "/convertir_a_romano/{number}")
    public String getNumeroRomano (@PathVariable Integer number){

        StringBuilder sb = new StringBuilder();
        sb.append("El número ");
        sb.append(number);
        sb.append(" ");
        sb.append("en números romanos es: ");
        sb.append(RomanNumberConverter.convertToRomanNumber(number));


        return sb.toString();
    }
    
}
