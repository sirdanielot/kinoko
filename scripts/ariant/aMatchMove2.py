# Ariant Coliseum : Battle Arena Lobby (980010000)
#   out00 (-601, 274)

QR_UnityPortal = 7050

returnMap = sm.getQRValue(QR_UnityPortal)
if returnMap and returnMap.isdigit():
    returnMap = int(returnMap)
else:
    returnMap = 100000000 # default to Henesys

sm.setQRValue(QR_UnityPortal, "")
sm.playPortalSE()
sm.warp(returnMap, "unityPortal2" if returnMap < 540000000 else "sp") # missing portal for CBD, NLC, and Mushroom Shrine
