SELECT DISTINCT CAR.CAR_ID AS CAR_ID
FROM CAR_RENTAL_COMPANY_CAR CAR
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY HISTORY
ON CAR.CAR_ID = HISTORY.CAR_ID
WHERE CAR.CAR_TYPE = '세단' AND HISTORY.START_DATE LIKE '2022-10%'
ORDER BY CAR.CAR_ID DESC;