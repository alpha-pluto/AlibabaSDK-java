package me.dan.alibabasdk.entity.trade;

import java.util.*;

import com.alibaba.fastjson.annotation.JSONField;

import me.dan.alibabasdk.util.DateUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;

public class AlibabaTradeStepOrderModel {

	private Long stepOrderId;

	/**
	 * @return 阶段id
	 */
	public Long getStepOrderId() {
		return stepOrderId;
	}

	/**
	 * 设置阶段id *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setStepOrderId(Long stepOrderId) {
		this.stepOrderId = stepOrderId;
	}

	private String stepOrderStatus;

	/**
	 * @return waitactivate 未开始（待激活）
	 *         waitsellerpush 等待卖家推进
	 *         success 本阶段完成
	 *         settlebill 分账
	 *         cancel 本阶段终止
	 *         inactiveandcancel 本阶段未开始便终止
	 *         waitbuyerpay 等待买家付款
	 *         waitsellersend 等待卖家发货
	 *         waitbuyerreceive 等待买家确认收货
	 *         waitselleract 等待卖家XX操作
	 *         waitbuyerconfirmaction 等待买家确认XX操作
	 */
	public String getStepOrderStatus() {
		return stepOrderStatus;
	}

	/**
	 * 设置waitactivate 未开始（待激活）
	 * waitsellerpush 等待卖家推进
	 * success 本阶段完成
	 * settlebill 分账
	 * cancel 本阶段终止
	 * inactiveandcancel 本阶段未开始便终止
	 * waitbuyerpay 等待买家付款
	 * waitsellersend 等待卖家发货
	 * waitbuyerreceive 等待买家确认收货
	 * waitselleract 等待卖家XX操作
	 * waitbuyerconfirmaction 等待买家确认XX操作 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setStepOrderStatus(String stepOrderStatus) {
		this.stepOrderStatus = stepOrderStatus;
	}

	private Integer stepPayStatus;

	/**
	 * @return 1 未冻结/未付款
	 *         2 已冻结/已付款
	 *         4 已退款
	 *         6 已转交易
	 *         8 交易未付款被关闭
	 */
	public Integer getStepPayStatus() {
		return stepPayStatus;
	}

	/**
	 * 设置1 未冻结/未付款
	 * 2 已冻结/已付款
	 * 4 已退款
	 * 6 已转交易
	 * 8 交易未付款被关闭 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setStepPayStatus(Integer stepPayStatus) {
		this.stepPayStatus = stepPayStatus;
	}

	private Integer stepNo;

	/**
	 * @return 阶段序列：1、2、3...
	 */
	public Integer getStepNo() {
		return stepNo;
	}

	/**
	 * 设置阶段序列：1、2、3... *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setStepNo(Integer stepNo) {
		this.stepNo = stepNo;
	}

	private Boolean lastStep;

	/**
	 * @return 是否最后一个阶段
	 */
	public Boolean getLastStep() {
		return lastStep;
	}

	/**
	 * 设置是否最后一个阶段 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setLastStep(Boolean lastStep) {
		this.lastStep = lastStep;
	}

	private Boolean hasDisbursed;

	/**
	 * @return 是否已打款给卖家
	 */
	public Boolean getHasDisbursed() {
		return hasDisbursed;
	}

	/**
	 * 设置是否已打款给卖家 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setHasDisbursed(Boolean hasDisbursed) {
		this.hasDisbursed = hasDisbursed;
	}

	private BigDecimal payFee;

	/**
	 * @return 创建时需要付款的金额，不含运费
	 */
	public BigDecimal getPayFee() {
		return payFee;
	}

	/**
	 * 设置创建时需要付款的金额，不含运费 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setPayFee(BigDecimal payFee) {
		this.payFee = payFee;
	}

	private BigDecimal actualPayFee;

	/**
	 * @return 应付款（含运费）= 单价×数量-单品优惠-店铺优惠+运费+修改的金额（除运费外，均指分摊后的金额）
	 */
	public BigDecimal getActualPayFee() {
		return actualPayFee;
	}

	/**
	 * 设置应付款（含运费）= 单价×数量-单品优惠-店铺优惠+运费+修改的金额（除运费外，均指分摊后的金额） *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setActualPayFee(BigDecimal actualPayFee) {
		this.actualPayFee = actualPayFee;
	}

	private BigDecimal discountFee;

	/**
	 * @return 本阶段分摊的店铺优惠
	 */
	public BigDecimal getDiscountFee() {
		return discountFee;
	}

	/**
	 * 设置本阶段分摊的店铺优惠 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setDiscountFee(BigDecimal discountFee) {
		this.discountFee = discountFee;
	}

	private BigDecimal itemDiscountFee;

	/**
	 * @return 本阶段分摊的单品优惠
	 */
	public BigDecimal getItemDiscountFee() {
		return itemDiscountFee;
	}

	/**
	 * 设置本阶段分摊的单品优惠 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setItemDiscountFee(BigDecimal itemDiscountFee) {
		this.itemDiscountFee = itemDiscountFee;
	}

	private BigDecimal price;

	/**
	 * @return 本阶段分摊的单价
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * 设置本阶段分摊的单价 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	private Long amount;

	/**
	 * @return 购买数量
	 */
	public Long getAmount() {
		return amount;
	}

	/**
	 * 设置购买数量 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	private BigDecimal postFee;

	/**
	 * @return 运费
	 */
	public BigDecimal getPostFee() {
		return postFee;
	}

	/**
	 * 设置运费 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setPostFee(BigDecimal postFee) {
		this.postFee = postFee;
	}

	private BigDecimal adjustFee;

	/**
	 * @return 修改价格修改的金额
	 */
	public BigDecimal getAdjustFee() {
		return adjustFee;
	}

	/**
	 * 设置修改价格修改的金额 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setAdjustFee(BigDecimal adjustFee) {
		this.adjustFee = adjustFee;
	}

	private String gmtCreate;

	/**
	 * @return 创建时间
	 */
	public String getGmtCreate() {
		return gmtCreate;
	}

	public Date getGmtCreateDate() {
		try {
			return DateUtil.parse(gmtCreate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 设置创建时间 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	private String gmtModified;

	/**
	 * @return 修改时间
	 */
	public String getGmtModified() {
		return gmtModified;
	}

	public Date getGmtModifiedDate() {
		try {
			return DateUtil.parse(gmtModified);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 设置修改时间 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setGmtModified(String gmtModified) {
		this.gmtModified = gmtModified;
	}

	private String enterTime;

	/**
	 * @return 开始时间
	 */
	public String getEnterTime() {
		return enterTime;
	}

	public Date getEnterTimeDate() {
		try {
			return DateUtil.parse(enterTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 设置开始时间 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setEnterTime(String enterTime) {
		this.enterTime = enterTime;
	}

	private String payTime;

	/**
	 * @return 付款时间
	 */
	public String getPayTime() {
		return payTime;
	}

	public Date getPayTimeDate() {
		try {
			return DateUtil.parse(payTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 设置付款时间 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	private String sellerActionTime;

	/**
	 * @return 卖家操作时间
	 */
	public String getSellerActionTime() {
		return sellerActionTime;
	}

	public Date getSellerActionTimeDate() {
		try {
			return DateUtil.parse(sellerActionTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 设置卖家操作时间 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setSellerActionTime(String sellerActionTime) {
		this.sellerActionTime = sellerActionTime;
	}

	private String endTime;

	/**
	 * @return 本阶段结束时间
	 */
	public String getEndTime() {
		return endTime;
	}

	public Date getEndTimeDate() {
		try {
			return DateUtil.parse(endTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 设置本阶段结束时间 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	private String messagePath;

	/**
	 * @return 卖家操作留言路径
	 */
	public String getMessagePath() {
		return messagePath;
	}

	/**
	 * 设置卖家操作留言路径 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setMessagePath(String messagePath) {
		this.messagePath = messagePath;
	}

	private String picturePath;

	/**
	 * @return 卖家上传图片凭据路径
	 */
	public String getPicturePath() {
		return picturePath;
	}

	/**
	 * 设置卖家上传图片凭据路径 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	private String message;

	/**
	 * @return 卖家操作留言
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 设置卖家操作留言 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	private Long templateId;

	/**
	 * @return 使用的模板id
	 */
	public Long getTemplateId() {
		return templateId;
	}

	/**
	 * 设置使用的模板id *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	private String stepName;

	/**
	 * @return 当前步骤的名称
	 */
	public String getStepName() {
		return stepName;
	}

	/**
	 * 设置当前步骤的名称 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	private String sellerActionName;

	/**
	 * @return 卖家操作名称
	 */
	public String getSellerActionName() {
		return sellerActionName;
	}

	/**
	 * 设置卖家操作名称 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setSellerActionName(String sellerActionName) {
		this.sellerActionName = sellerActionName;
	}

	private Long buyerPayTimeout;

	/**
	 * @return 买家不付款的超时时间(秒)
	 */
	public Long getBuyerPayTimeout() {
		return buyerPayTimeout;
	}

	/**
	 * 设置买家不付款的超时时间(秒) *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setBuyerPayTimeout(Long buyerPayTimeout) {
		this.buyerPayTimeout = buyerPayTimeout;
	}

	private Long buyerConfirmTimeout;

	/**
	 * @return 买家不确认的超时时间
	 */
	public Long getBuyerConfirmTimeout() {
		return buyerConfirmTimeout;
	}

	/**
	 * 设置买家不确认的超时时间 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setBuyerConfirmTimeout(Long buyerConfirmTimeout) {
		this.buyerConfirmTimeout = buyerConfirmTimeout;
	}

	private Boolean needLogistics;

	/**
	 * @return 是否需要物流
	 */
	public Boolean getNeedLogistics() {
		return needLogistics;
	}

	/**
	 * 设置是否需要物流 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setNeedLogistics(Boolean needLogistics) {
		this.needLogistics = needLogistics;
	}

	private Boolean needSellerAction;

	/**
	 * @return 是否需要卖家操作和买家确认
	 */
	public Boolean getNeedSellerAction() {
		return needSellerAction;
	}

	/**
	 * 设置是否需要卖家操作和买家确认 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setNeedSellerAction(Boolean needSellerAction) {
		this.needSellerAction = needSellerAction;
	}

	private Boolean transferAfterConfirm;

	/**
	 * @return 阶段结束是否打款
	 */
	public Boolean getTransferAfterConfirm() {
		return transferAfterConfirm;
	}

	/**
	 * 设置阶段结束是否打款 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setTransferAfterConfirm(Boolean transferAfterConfirm) {
		this.transferAfterConfirm = transferAfterConfirm;
	}

	private Boolean needSellerCallNext;

	/**
	 * @return 是否需要卖家推进
	 */
	public Boolean getNeedSellerCallNext() {
		return needSellerCallNext;
	}

	/**
	 * 设置是否需要卖家推进 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setNeedSellerCallNext(Boolean needSellerCallNext) {
		this.needSellerCallNext = needSellerCallNext;
	}

	private Boolean instantPay;

	/**
	 * @return 是否允许即时到帐
	 */
	public Boolean getInstantPay() {
		return instantPay;
	}

	/**
	 * 设置是否允许即时到帐 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setInstantPay(Boolean instantPay) {
		this.instantPay = instantPay;
	}

}