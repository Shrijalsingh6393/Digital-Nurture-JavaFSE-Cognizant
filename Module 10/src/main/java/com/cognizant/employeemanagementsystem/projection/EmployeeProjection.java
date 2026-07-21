package com.cognizant.employeemanagementsystem.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {

    Long getId();

    String getName();

    String getEmail();

    // Exercise 8: Interface-based projection using @Value expression
    @Value("#{target.name + ' <' + target.email + '>'}")
    String getFormattedContactInfo();
}
