package com.mx.alternativecourses.api.domain.exception;

import lombok.Getter;

import java.util.List;


@Getter
public class BankAggregationException  extends Exception{

    private List<String> errorCodes ;

    public BankAggregationException(List<String>  errorCodes ,String message) {
        super(message);
        this.errorCodes = errorCodes;
    }

}
