package com.infosys.poolcarz.fare.utility;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ClientErrorInfo {

    String code;

    String message;

    public ClientErrorInfo(){
        super();
    }

    public ClientErrorInfo(String code,String message){
        super();
        this.code=code;
        this.message=message;
    }


}
