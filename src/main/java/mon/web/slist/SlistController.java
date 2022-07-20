package mon.web.slist;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mon.entity.Category;
import mon.entity.Goods;
import mon.entity.GoodsJoinMakerCate;
import mon.entity.Maker;
import mon.service.GoodsMakerCategoryService;

@Controller
@RequestMapping("/slist")
@Transactional
public class SlistController {

	private final GoodsMakerCategoryService goodsService;

	@Autowired
	public SlistController(GoodsMakerCategoryService goodsService) {
		this.goodsService = goodsService;
	}

	// 一覧表示
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model model) {
		List<GoodsJoinMakerCate> goodsList = goodsService.getGoodsMakerCategoryList();
		model.addAttribute("GOODSLIST", goodsList);
		return "slist/index";
	}

	// 1件編集
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, Model model) {
		Goods goods = goodsService.getGoods(id);
		SlistForm form = new SlistForm();
		BeanUtils.copyProperties(goods, form);// source->targetにコピー
		return modelAndViewForEdit(model,form);
	}
	// 1件編集した情報を確認
	@RequestMapping(value = "/editconfirm", method = RequestMethod.POST)
	public String editconfirm(@Validated SlistForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return modelAndViewForEdit(model,form);
		}
		System.out.println("---------------------" + form.getMakerId());
		Category category = goodsService.getCategory(form.getCategoryId());
		Maker maker = goodsService.getMaker(form.getMakerId());
		form.setCategoryName(category.getCategoryName());
		form.setMakerName(maker.getMakerName());
		return "slist/editconfirm";
	}

	// 1件編集した情報を更新
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateExe(@Validated SlistForm form, @RequestParam("btnName") String btnName, Model model) {
		if ("戻る".equals(btnName)) {// 戻るボタン押下
			return modelAndViewForEdit(model,form);
		} else {
			Goods goods = new Goods();
			BeanUtils.copyProperties(form, goods);// source->targetにコピー
			goodsService.update(goods);
			return "redirect:/slist"; // リダイレクト先はURL
		}
	}

	// 1件削除
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, Model model) {
		GoodsJoinMakerCate goodsMakerCate = goodsService.getGoodsMakerCategory(id);
		model.addAttribute("GOODSJOIN", goodsMakerCate);
		return "slist/deleteconfirm";
	}

	// 1件削除実行
	@RequestMapping(value = "/deleteexe/{id}", method = RequestMethod.GET)
	public String deleteexe(@PathVariable("id") int id, Model model) {
		Goods goods=goodsService.getGoods(id);
		goodsService.delete(goods);
		return "redirect:/slist";
	}

	private String modelAndViewForEdit(Model model, SlistForm form) {
		List<Maker> makerList = goodsService.getMakerList();
		List<Category> categoryList = goodsService.getCategoryList();
		model.addAttribute("MAKERLIST", makerList);
		model.addAttribute("CATEGORYLIST", categoryList);
		model.addAttribute(form);
		return "slist/edit";
	}
}