package mon.web.slist;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class SlistForm {
	private Integer goodsId;

	@NotBlank
	private String goodsName;

	@NotNull
	private Integer goodsTanka;

	private Integer makerId;
	private String makerName;

	private Integer categoryId;
	private String categoryName;

	private Integer version;

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsTanka() {
		return goodsTanka;
	}

	public void setGoodsTanka(Integer goodsTanka) {
		this.goodsTanka = goodsTanka;
	}

	public Integer getMakerId() {
		return makerId;
	}

	public void setMakerId(Integer makerId) {
		this.makerId = makerId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getMakerName() {
		return makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
