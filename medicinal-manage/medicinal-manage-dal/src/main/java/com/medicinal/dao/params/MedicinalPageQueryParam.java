package com.medicinal.dao.params;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicinalPageQueryParam extends PageQueryBase{

    private String code;

    private String name;

}
