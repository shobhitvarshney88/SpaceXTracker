package com.android.spacextracker.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

class GetSpaceXResponse : ArrayList<SpaceXData>()

@Parcelize
data class SpaceXData(
    val details: String? = null,
    val flight_number: Int? = null,
    val is_tentative: Boolean? = null,
    val last_date_update: String? = null,
    val last_ll_launch_date: String? = null,
    val last_ll_update: String? = null,
    val last_wiki_launch_date: String? = null,
    val last_wiki_revision: String? = null,
    val last_wiki_update: String? = null,
    val launch_date_local: String? = null,
    val launch_date_source: String? = null,
    val launch_date_unix: Int? = null,
    val launch_date_utc: String? = null,
    val launch_failure_details: LaunchFailureDetails? = null,
    val launch_site: LaunchSite? = null,
    val launch_success: Boolean? = null,
    val launch_window: Int? = null,
    val launch_year: String? = null,
    val links: Links? = null,
    val mission_id: List<String>? = null,
    val mission_name: String? = null,
    val rocket: Rocket? = null,
    val ships: List<String>? = null,
    val static_fire_date_unix: Int? = null,
    val static_fire_date_utc: String? = null,
    val tbd: Boolean? = null,
    val telemetry: Telemetry? = null,
    val tentative_max_precision: String? = null,
    val timeline: Timeline? = null,
    val upcoming: Boolean? = null
) : Parcelable

@Parcelize
data class LaunchFailureDetails(
    val altitude: Int? = null,
    val reason: String? = null,
    val time: Int? = null
) : Parcelable

@Parcelize
data class LaunchSite(
    val site_id: String? = null,
    val site_name: String? = null,
    val site_name_long: String? = null
) : Parcelable

@Parcelize
data class Links(
    val article_link: String? = null,
    val flickr_images: List<String>? = null,
    val mission_patch: String? = null,
    val mission_patch_small: String? = null,
    val presskit: String? = null,
    val reddit_campaign: String? = null,
    val reddit_launch: String? = null,
    val reddit_media: String? = null,
    val reddit_recovery: String? = null,
    val video_link: String? = null,
    val wikipedia: String? = null,
    val youtube_id: String? = null
) : Parcelable

@Parcelize
data class Rocket(
    val fairings: Fairings? = null,
    val first_stage: FirstStage? = null,
    val rocket_id: String? = null,
    val rocket_name: String? = null,
    val rocket_type: String? = null,
    val second_stage: SecondStage? = null
) : Parcelable

@Parcelize
data class Telemetry(
    val flight_club: String? = null
) : Parcelable

@Parcelize
data class Timeline(
    val beco: Int? = null,
    val center_core_boostback: Int? = null,
    val center_core_entry_burn: Int? = null,
    val center_core_landing: Int? = null,
    val center_stage_sep: Int? = null,
    val dragon_bay_door_deploy: Int? = null,
    val dragon_separation: Int? = null,
    val dragon_solar_deploy: Int? = null,
    val engine_chill: Int? = null,
    val fairing_deploy: Int? = null,
    val first_stage_boostback_burn: Int? = null,
    val first_stage_entry_burn: Int? = null,
    val first_stage_landing: Int? = null,
    val first_stage_landing_burn: Int? = null,
    val go_for_launch: Int? = null,
    val go_for_prop_loading: Int? = null,
    val ignition: Int? = null,
    val liftoff: Int? = null,
    val maxq: Int? = null,
    val meco: Int? = null,
    val payload_deploy: Int? = null,
    val payload_deploy_1: Int? = null,
    val payload_deploy_2: Int? = null,
    val prelaunch_checks: Int? = null,
    val propellant_pressurization: Int? = null,
    val rp1_loading: Int? = null,
    val second_stage_ignition: Int? = null,
    val second_stage_restart: Int? = null,
    val side_core_boostback: Int? = null,
    val side_core_entry_burn: Int? = null,
    val side_core_landing: Int? = null,
    val side_core_sep: Int? = null,
    val stage1_lox_loading: Int? = null,
    val stage1_rp1_loading: Int? = null,
    val stage2_lox_loading: Int? = null,
    val stage2_rp1_loading: Int? = null,
    val stage_sep: Int? = null,
    val webcast_launch: Int? = null,
    val webcast_liftoff: Int? = null
) : Parcelable

@Parcelize
data class Fairings(
    val recovered: Boolean? = null,
    val recovery_attempt: Boolean? = null,
    val reused: Boolean? = null,
    val ship: String? = null
) : Parcelable

@Parcelize
data class FirstStage(
    val cores: List<Core>? = null
) : Parcelable

@Parcelize
data class SecondStage(
    val block: Int? = null,
    val payloads: List<Payload>? = null
) : Parcelable

@Parcelize
data class Core(
    val block: Int? = null,
    val core_serial: String? = null,
    val flight: Int? = null,
    val gridfins: Boolean? = null,
    val land_success: Boolean? = null,
    val landing_intent: Boolean? = null,
    val landing_type: String? = null,
    val landing_vehicle: String? = null,
    val legs: Boolean? = null,
    val reused: Boolean? = null
) : Parcelable

@Parcelize
data class Payload(
    val cap_serial: String? = null,
    val cargo_manifest: String? = null,
    val customers: List<String>? = null,
    val flight_time_sec: Int? = null,
    val manufacturer: String? = null,
    val mass_returned_kg: Double? = null,
    val mass_returned_lbs: Double? = null,
    val nationality: String? = null,
    val norad_id: List<Int>? = null,
    val orbit: String? = null,
    val orbit_params: OrbitParams? = null,
    val payload_id: String? = null,
    val payload_mass_kg: Double? = null,
    val payload_mass_lbs: Double? = null,
    val payload_type: String? = null,
    val reused: Boolean? = null,
    val uid: String? = null
) : Parcelable

@Parcelize
data class OrbitParams(
    val apoapsis_km: Double? = null,
    val arg_of_pericenter: Double? = null,
    val eccentricity: Double? = null,
    val epoch: String? = null,
    val inclination_deg: Double? = null,
    val lifespan_years: Double? = null,
    val longitude: Double? = null,
    val mean_anomaly: Double? = null,
    val mean_motion: Double? = null,
    val periapsis_km: Double? = null,
    val period_min: Double? = null,
    val raan: Double? = null,
    val reference_system: String? = null,
    val regime: String? = null,
    val semi_major_axis_km: Double? = null
) : Parcelable
