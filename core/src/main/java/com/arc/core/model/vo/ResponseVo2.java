package com.arc.core.model.vo;

import com.arc.core.enums.system.ProjectCodeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 该类对controller返回值做了统一封装
 * 返回数据的数据具有一致的格式
 *
 * @param <T>
 * @author May
 */
@Getter
@Setter
@ToString
public class ResponseVo2<T>
        extends ResponseEntity
        implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     * 状态信息 status 用String或者数字类型（long/int？）。私以为：类型是数字类型 可能高效一些，
     */
    private int status;

    /**
     * 状态信息
     */
    private String message;


    /**
     * 有效数据
     */
    private T data;

    private LocalDateTime timestamp;
    private String error;
    private String path;

    //    ""timestamp: "2020-01-25T07:41:43.903+0000",
    //    "status": 404,
    //    "error": "Not Found",
    //    "message": "No handler found for GET /zero/sys/resource/scan/auto",
    //    "path": "/zero/sys/resource/scan/auto"


    //构造器
    public ResponseVo2() {
        super(HttpStatus.OK);
    }

    public ResponseVo2(T data) {
        super(HttpStatus.OK);
        this.data = data;
    }

    public ResponseVo2(ProjectCodeEnum projectCode) {
        super(HttpStatus.OK);
        this.status = projectCode.getCode();
        this.message = projectCode.getMsg();
        this.data = null;
    }

    public ResponseVo2(int status, String message, T data) {
        super(HttpStatus.OK);
        this.status = status;
        this.message = message;
        this.data = data;
    }

    //success方法
    public static <T> ResponseVo2<T> success() {
        return new ResponseVo2<T>(ProjectCodeEnum.SUCCESS.getCode(), ProjectCodeEnum.SUCCESS.getMsg(), null);
    }

    public static <T> ResponseVo2<T> success(T data) {
        return new ResponseVo2<T>(ProjectCodeEnum.SUCCESS.getCode(), ProjectCodeEnum.SUCCESS.getMsg(), data);
    }

    public static <T> ResponseVo2<T> success(ProjectCodeEnum enumCode) {
        return new ResponseVo2<T>(enumCode.getCode(), enumCode.getMsg(), null);
    }

    public static <T> ResponseVo2<T> success(ProjectCodeEnum enumCode, T data) {
        return new ResponseVo2<T>(enumCode.getCode(), enumCode.getMsg(), data);
    }

    //失败
    public static <T> ResponseVo2<T> failure(ProjectCodeEnum enumCode) {
        return new ResponseVo2<T>(enumCode.getCode(), enumCode.getMsg(), null);
    }

    public static <T> ResponseVo2<T> failure(T data) {
        return new ResponseVo2<T>(ProjectCodeEnum.FAILURE.getCode(), ProjectCodeEnum.FAILURE.getMsg(), data);
    }

    public static <T> ResponseVo2<T> failure(ProjectCodeEnum enumCode, T data) {
        return new ResponseVo2<T>(enumCode.getCode(), enumCode.getMsg(), data);
    }

    public static ResponseVo2 failure() {
        return new ResponseVo2(ProjectCodeEnum.FAILURE);
    }

    public static ResponseVo2 failure(int status, String message) {
        return new ResponseVo2(status, message, ProjectCodeEnum.FAILURE);
    }


//    public static <T> ResponseVo<T> ok(T body) {
//        ResponseEntity.BodyBuilder builder = ok();
//        return builder.body(body);
//        super(body);
//        return null;
//    }

//    /**
//     * 返回值实际上是一个map<Object,Object> 非常自由
//     *
//     * @param data
//     * @param <T>
//     * @return
//     */
//    public static <T> ResponseEntity<Map<Object, Object>> ok(T data) {
//        Map<Object, Object> map = new HashMap<>(2);
//        map.put("data", data);
//        map.put("status", 200);
//        return ResponseEntity.ok(map);
//    }

    public static <T> ResponseEntity<ResponseVo2<T>> ok(int i, T data) {
        ResponseVo2 responseVo = new ResponseVo2<>(ProjectCodeEnum.SUCCESS.getCode(), ProjectCodeEnum.SUCCESS.getMsg(), data);
        return ResponseEntity.ok(responseVo);
    }

//
//    /**
//     * 处理微服务的返回结果
//     *
//     * @param response
//     * @param <T>
//     * @return
//     */
//    public static <T> ResponseVo<T> buildResponse(MicroServiceResponse<T> response) {
//        if (response == null) {
//            throw new BusinessRuntimeException(ProjectCodeEnum.NULL_RESPONSE);
//        }
//        return StringUtils.equals(response.getCode(), ProjectCodeEnum.SUCCESS.getCode()) ? ResponseVo.success(response.getData()) : ResponseVo.failure(ProjectCodeEnum.buildFailure(response.getCode(), response.getMsg()));
//    }
//
//    /**
//     * 处理微服务的返回结果（类型转换）
//     *
//     * @param response
//     * @param <T>
//     * @return
//     */
//    public static <T> ResponseVo<T> convertResponse(MicroServiceResponse<?> response, Class<T> target) {
//        if (response == null || target == null) {
//            throw new BusinessRuntimeException(ProjectCodeEnum.NULL_RESPONSE);
//        }
//        T instance = BeanCopierUtil.copyBean(response.getData(), target);
//        return StringUtils.equals(response.getCode(), ProjectCodeEnum.SUCCESS.getCode()) ? ResponseVo.success(instance) : ResponseVo.failure(ProjectCodeEnum.buildFailure(response.getCode(), response.getMsg()));
//    }
//
//    /**
//     * 处理微服务的返回结果（分页类型转换）
//     *
//     * @param response
//     * @param <T>
//     * @return
//     */
//    public static <T> ResponseVo<PageResponse<T>> convertPageResponse(MicroServiceResponse<? extends PageResponse> response, Class<T> target) {
//        if (response == null || target == null) {
//            throw new BusinessRuntimeException(ProjectCodeEnum.NULL_RESPONSE);
//        }
//        if (response.getData() == null) {
//            throw new BusinessRuntimeException(ProjectCodeEnum.PAGE_NULL_RESPONSE);
//        }
//        List<T> list = BeanCopierUtil.copyList(response.getData().getData(), target);
//        PageResponse<T> instance = new PageResponse<>();
//        instance.setData(list);
//        instance.setTotalPages(response.getData().getTotalPages());
//        instance.setTotalElements(response.getData().getTotalElements());
//        return StringUtils.equals(response.getCode(), ProjectCodeEnum.SUCCESS.getCode()) ? ResponseVo.success(instance) : ResponseVo.failure(ProjectCodeEnum.buildFailure(response.getCode(), response.getMsg()));
//    }
//
//    /**
//     * 处理微服务的返回结果（列表类型转换）
//     *
//     * @param response
//     * @param <T>
//     * @return
//     */
//    public static <T> ResponseVo<List<T>> convertListResponse(MicroServiceResponse<? extends List> response, Class<T> target) {
//        if (response == null || target == null) {
//            throw new BusinessRuntimeException(ProjectCodeEnum.NULL_RESPONSE);
//        }
//        List<T> instance = BeanCopierUtil.copyList(response.getData(), target);
//        return StringUtils.equals(response.getCode(), ProjectCodeEnum.SUCCESS.getCode()) ? ResponseVo.success(instance) : ResponseVo.failure(ProjectCodeEnum.buildFailure(response.getCode(), response.getMsg()));
//    }
//
//    /**
//     * 处理微服务的返回结果（含参数名映射列表类型转换）
//     *
//     * @param response
//     * @param <T>
//     * @return
//     */
//    public static <T> ResponseVo<List<T>> convertListResponse(MicroServiceResponse<? extends List> response, Class<T> target, Map<String, String> relation) {
//        if (response == null || target == null) {
//            throw new BusinessRuntimeException(ProjectCodeEnum.NULL_RESPONSE);
//        }
//        List<T> instance = BeanCopierUtil.copyList(response.getData(), target, relation);
//        return StringUtils.equals(response.getCode(), ProjectCodeEnum.SUCCESS.getCode()) ? ResponseVo.success(instance) : ResponseVo.failure(ProjectCodeEnum.buildFailure(response.getCode(), response.getMsg()));
//    }

}
