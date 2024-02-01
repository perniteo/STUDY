SELECT CONCAT('/home/grep/src/', 
              FILE.BOARD_ID, '/', 
              FILE.FILE_ID, 
              FILE.FILE_NAME, 
              FILE.FILE_EXT) AS FILE_PATH FROM USED_GOODS_BOARD BOARD 
JOIN USED_GOODS_FILE FILE ON BOARD.BOARD_ID = FILE.BOARD_ID
WHERE VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
ORDER BY FILE.FILE_ID DESC;