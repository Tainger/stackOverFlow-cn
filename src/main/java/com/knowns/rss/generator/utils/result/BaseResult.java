package com.knowns.rss.generator.utils.result;


import com.knowns.rss.generator.utils.result.interfaces.IErrorCode;

/**
 * 返回给客户端执行结果的消息类，不需要带数据
 *
 * @author liying22923
 * @since 2020/6/24
 */
public class BaseResult {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6673395649748854442L;

    /**
     * 请求唯一ID
     */
    private String            requestId;

    /**
     * 成功标记
     */
    private boolean           success;

    /**
     * 操作结果代码
     */
    private String            code;

    /**
     * 操作消息
     */
    private String            message;

    public BaseResult() {
        this.code = CommonResultCode.SUCCESS.getCode();
        this.success = true;
        this.message = CommonResultCode.SUCCESS.getMessage();
    }

    /**
     * 设置错误信息
     *
     * @param code 错误码
     * @param message 错误详细信息
     */
    public <R extends BaseResult> R setError(String code, String message) {
        this.code = code;
        this.success = false;
        this.message = message;
        return (R) this;
    }

    /**
     * 设置错误信息
     *
     * @param errcode 错误码
     * @param args 错误详细信息
     * @return R
     */
    public <R extends BaseResult> R setError(IErrorCode errcode, Object... args) {
        this.code = errcode.getCode();
        this.success = false;
        String err = errcode.getMessage();
        if (args == null || args.length == 0) {
            this.message = err;
        } else {
            this.message = String.format(err, args);
        }
        return (R) this;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "requestId='" + requestId + '\'' +
                ", success=" + success +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
