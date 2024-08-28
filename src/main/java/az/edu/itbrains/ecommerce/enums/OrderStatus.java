package az.edu.itbrains.ecommerce.enums;

import jakarta.persistence.*;


public enum OrderStatus {
    PENDING,      // Sifariş gözləmə vəziyyətindədir
    PROCESSING,   // Sifariş işləndiyi vəziyyətdədir
    SHIPPED,      // Sifariş göndərildi
    DELIVERED,    // Sifariş müştəriyə təslim edildi
    CANCELED      // Sifariş ləğv edildi
}

