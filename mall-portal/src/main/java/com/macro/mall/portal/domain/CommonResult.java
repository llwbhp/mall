package com.macro.mall.portal.domain;

import java.io.Serializable;

/**
 * 响应操作结果
 * 
 * <pre>
 *  {
 *      errno： 错误码，
 *      errmsg：错误消息，
 *      data：  响应数据
 *  }
 * </pre>
 *
 * <p>
 * 错误码：
 * <ul>
 * <li>0，成功；
 * <li>4xx，前端错误，说明前端开发者需要重新了解后端接口使用规范：
 * <ul>
 * <li>401，参数错误，即前端没有传递后端需要的参数；
 * <li>402，参数值错误，即前端传递的参数值不符合后端接收范围。
 * </ul>
 * <li>5xx，后端错误，除501外，说明后端开发者应该继续优化代码，尽量避免返回后端错误码：
 * <ul>
 * <li>501，验证失败，即后端要求用户登录；
 * <li>502，系统内部错误，即没有合适命名的后端内部错误；
 * <li>503，业务不支持，即后端虽然定义了接口，但是还没有实现功能；
 * <li>504，更新数据失效，即后端采用了乐观锁更新，而并发更新时存在数据更新失效；
 * <li>505，更新数据失败，即后端数据库更新失败（正常情况应该更新成功）。
 * </ul>
 * </ul>
 */
public class CommonResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String OPERATOR_FAILED = "操作失败";
    private static final String OPERATOR_SUCCESS = "操作成功";
    // 操作成功
    public static final int SUCCESS = 200;
    // 操作失败
    public static final int FAILED = 500;
    private Integer errno;
    private String errmsg;
    private T data;

    public CommonResult() {
    }

    /**
     * 
     * 创建一个新的实例 CommonResult.
     * 
     * <p>
     * Title:
     * </p>
     * 
     * <p>
     * Description:
     * </p>
     * 
     * 
     */

    public CommonResult(Integer errno, String errmsg) {
        this.errmsg = errmsg;
        this.errno = errno;
    }

    public CommonResult(Integer errno, String errmsg, T data) {
        this.errmsg = errmsg;
        this.errno = errno;
        this.data = data;
    }

    /**
     * 
     * 
     * 创建一个新的实例 CommonResult.
     * 
     * <p>
     * Title:普通成功返回
     * </p>
     * 
     * <p>
     * Description: 普通成功返回
     * </p>
     * 
     * @param data 需要返回的数据
     */
    public CommonResult(T data) {
        this.errno = SUCCESS;
        this.errmsg = OPERATOR_SUCCESS;
        this.data = data;
    }

    /**
     * 
     * 
     * 创建一个新的实例 CommonResult.
     * 
     * <p>
     * Title: 普通成功返回
     * </p>
     * 
     * <p>
     * Description: 带数据和消息
     * </p>
     * 
     * @param message
     * @param data
     */
    public CommonResult(String message, T data) {
        this.errno = SUCCESS;
        this.errmsg = message;
        this.data = data;
    }

    public static CommonResult buildSuccessResponseWithoutData() {
        return new CommonResult<>(SUCCESS, OPERATOR_SUCCESS);
    }

    public static CommonResult buildSuccessResponseWithMessage(String message) {
        return new CommonResult<>(SUCCESS, message);
    }

    public static CommonResult buildErrorResponse() {
        return new CommonResult<>(FAILED, OPERATOR_FAILED);
    }

    public static CommonResult buildErrorResponseWithMessage(String message) {
        return new CommonResult<>(FAILED, message);
    }

    /**
     * 
     * getter method
     * 
     * @return the errno
     * 
     */

    public Integer getErrno() {
        return errno;
    }

    /**
     * 
     * setter method
     * 
     * @param errno the errno to set
     * 
     */

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    /**
     * 
     * getter method
     * 
     * @return the errmsg
     * 
     */

    public String getErrmsg() {
        return errmsg;
    }

    /**
     * 
     * setter method
     * 
     * @param errmsg the errmsg to set
     * 
     */

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    /**
     * 
     * getter method
     * 
     * @return the data
     * 
     */

    public T getData() {
        return data;
    }

    /**
     * 
     * setter method
     * 
     * @param data the data to set
     * 
     */

    public void setData(T data) {
        this.data = data;
    }

}
