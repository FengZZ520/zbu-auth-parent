package com.zbu.system.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.ref.SoftReference;

/**
 * ClassName: ZBUException
 * Package: com.zbu.system.exception
 * Description:
 *
 * @Author: 冯振卓
 * @Create: 2023/2/23 - 18:40
 * @Version: v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZBUException extends RuntimeException{
    private Integer code;
    private String msg;
}
