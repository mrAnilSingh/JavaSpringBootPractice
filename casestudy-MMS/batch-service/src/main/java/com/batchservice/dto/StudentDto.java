//package com.capg.batchservice.dto;
//
//import io.swagger.v3.oas.annotations.media.Schema;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotEmpty;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Schema(
//        description = "student Dto model information"
//)
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class StudentDto {
//
//    private Long studentId;
//
//    @Schema(
//            description = "Name"
//    )
//    @NotEmpty(message = "student Name should not be null or empty ")
//    private String studentName;
//
//    @Schema(
//            description = "Email"
//    )
//    @NotEmpty(message = "student email should not be null or empty ")
//    @Email(message = "Enter Valid Email address")
//    private String email;
//
//
//    @Schema(
//            description = "course code"
//    )
//    @NotEmpty(message = "course code should not be null or empty ")
//    private String batchCode;
//}
//
