# ac-rest
An auxiliary server for processing and executing AC-conditioner requests to Samsung Smartthings API.

Can be used with Home Assistant, as it caches the status queries (Home Assistant asks for status every 3 seconds).
ac-rest will refresh the status from the Samsung Cloud periodically (once per minute).

## configuration

Expects ENV variables:
* DEVICES comma separated list of devices to refresh status periodically.
* API_TOKEN your Samsung API token with "Bearer: " prefix.
* API_URL https://api.smartthings.com/v1/devices/

## endpoints exposed:


| method | URL                                    | payload                                                      | comment |
|--------|----------------------------------------|--------------------------------------------------------------|---------|
| GET    | /devices/{device}/power                | "on", "off                                                   |         |
| POST   | /devices/{device}/ac_mode              | "auto", "cool", "dry", "off"                                 |         |
| POST   | /devices/{device}/fan_mode             | "low", "medium", "high", "turbo"                             |         |
| POST   | /devices/{device}/fan_oscillation_mode | "vertical", "horizontal", "fixed", "fixedLeft", "fixedRight" |         |
| POST   | /devices/{device}/beep                 | "on", "off"                                                  |         |
| POST   | /devices/{device}/preset               | "off", "speed", "sleep", "windFree", "windFreeSleep"         |         |

## parameters (POST payload)

{device} is your device id, taken from https://api.smartthings.com/v1/devices/

```json
{"value": "yourValueHere"}

```

## example
Set power on, then set ac-mode to cooling:

```
POST /devices/{device}/power  {"value": "on"}
POST /devices/{device}/ac_mode  {"value": "cool"}
```



