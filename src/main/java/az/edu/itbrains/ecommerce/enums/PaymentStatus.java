package az.edu.itbrains.ecommerce.enums;

public enum PaymentStatus {
    PENDING,        // Ödəniş gözləmə vəziyyətindədir
    COMPLETED,      // Ödəniş tamamlanıb
    FAILED,         // Ödəniş uğursuz oldu
    CANCELED,       // Ödəniş ləğv edilib
    REFUNDED        // Ödəniş geri qaytarılıb
}

