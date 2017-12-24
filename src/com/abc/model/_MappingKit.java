package com.abc.model;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * Generated by JFinal, do not modify this file.
 * <pre>
 * Example:
 * public void configPlugin(Plugins me) {
 *     ActiveRecordPlugin arp = new ActiveRecordPlugin(...);
 *     _MappingKit.mapping(arp);
 *     me.add(arp);
 * }
 * </pre>
 */
public class _MappingKit {

	public static void mapping(ActiveRecordPlugin arp) {
		arp.addMapping("blog", "id", Blog.class);
		arp.addMapping("sup_hotels", "id", SupHotels.class);
		arp.addMapping("sup_jia_chuang", "", SupJiaChuang.class);
		// Composite Primary Key order: id,sup_hid
		arp.addMapping("sup_jia_zao", "id,sup_hid", SupJiaZao.class);
		arp.addMapping("sup_restaurant", "id", SupRestaurant.class);
		arp.addMapping("sup_room", "id", SupRoom.class);
		arp.addMapping("sup_room_price", "id", SupRoomPrice.class);
		arp.addMapping("sup_ticket", "id", SupTicket.class);
		arp.addMapping("sys_address", "id", SysAddress.class);
		arp.addMapping("sys_department", "id", SysDepartment.class);
		arp.addMapping("sys_member", "id", SysMember.class);
		arp.addMapping("sys_permission", "id", SysPermission.class);
		arp.addMapping("sys_persons", "id", SysPersons.class);
		arp.addMapping("sys_role", "id", SysRole.class);
		arp.addMapping("sys_role_permission", "id", SysRolePermission.class);
		arp.addMapping("sys_station", "id", SysStation.class);
		arp.addMapping("sys_third_party", "id", SysThirdParty.class);
		arp.addMapping("sys_user", "id", SysUser.class);
		arp.addMapping("sys_user_role", "id", SysUserRole.class);
		arp.addMapping("yh_bizzone", "bizzoneid", YhBizzone.class);
		arp.addMapping("yh_city", "cityid", YhCity.class);
		arp.addMapping("yh_country", "countryid", YhCountry.class);
		// Composite Primary Key order: id,type
		arp.addMapping("yh_data_dic", "id,type", YhDataDic.class);
		arp.addMapping("yh_hotels", "id", YhHotels.class);
		arp.addMapping("yh_hotels_order", "id", YhHotelsOrder.class);
		arp.addMapping("yh_images", "id", YhImages.class);
		arp.addMapping("yh_journey", "id", YhJourney.class);
		arp.addMapping("yh_label", "id", YhLabel.class);
		arp.addMapping("yh_label_city", "id", YhLabelCity.class);
		arp.addMapping("yh_order", "id", YhOrder.class);
		arp.addMapping("yh_order_passengers", "id", YhOrderPassengers.class);
		arp.addMapping("yh_plane_order", "id", YhPlaneOrder.class);
		arp.addMapping("yh_play_month", "id", YhPlayMonth.class);
		arp.addMapping("yh_product", "id", YhProduct.class);
		arp.addMapping("yh_product_distance", "id", YhProductDistance.class);
		arp.addMapping("yh_product_label", "id", YhProductLabel.class);
		arp.addMapping("yh_restaurant", "id", YhRestaurant.class);
		arp.addMapping("yh_restaurant_order", "id", YhRestaurantOrder.class);
		arp.addMapping("yh_room", "id", YhRoom.class);
		arp.addMapping("yh_season_travel", "id", YhSeasonTravel.class);
		arp.addMapping("yh_services_facilities", "id", YhServicesFacilities.class);
		arp.addMapping("yh_state", "stateid", YhState.class);
		arp.addMapping("yh_stroke", "id", YhStroke.class);
		arp.addMapping("yh_sup_city", "id", YhSupCity.class);
		arp.addMapping("yh_supplier", "id", YhSupplier.class);
		arp.addMapping("yh_ticket", "id", YhTicket.class);
		arp.addMapping("yh_ticket_order", "id", YhTicketOrder.class);
		arp.addMapping("yh_travel", "id", YhTravel.class);
		arp.addMapping("yh_travel_day", "id", YhTravelDay.class);
		arp.addMapping("yh_travel_detail", "id", YhTravelDetail.class);
		arp.addMapping("yh_upload_log", "id", YhUploadLog.class);
		arp.addMapping("yh_zone", "zoneid", YhZone.class);
	}
}
