INSERT INTO PARAM_CATEGORY (CAT_ID, CAT_CODE, CAT_NAME, CAT_MORE)
VALUES (1, 'tombe', 'Tombes', true);
INSERT INTO PARAM_CATEGORY (CAT_ID, CAT_CODE, CAT_NAME, CAT_MORE)
VALUES (2, 'temple', 'Temples', true);
INSERT INTO PARAM_CATEGORY (CAT_ID, CAT_CODE, CAT_NAME, CAT_MORE)
VALUES (3, 'autre', 'Autres bizarreries', false);

INSERT INTO USR_USER(USR_ID, USR_NAME) VALUES (1, 'TEST');

INSERT INTO PARAM_ITEM (ITEM_ID, ITEM_NAME, CAT_ID, USR_ID, ITEM_IMG_HEAD_URL, ITEM_COMMENTS, ITEM_CONTENT)
VALUES (1, "tombe1", 1, 1, "../../../../assets/images/imageTombe1.jpg", "La tombe 1 est blablabla", "Test de contenu tombe1");
INSERT INTO PARAM_ITEM (ITEM_ID, ITEM_NAME, CAT_ID, USR_ID, ITEM_IMG_HEAD_URL, ITEM_COMMENTS, ITEM_CONTENT)
VALUES (2, "tombe2", 1, 1, "../../../../assets/images/imageTombe2.jpg", "La tombe 2 est encore mieux", "Test de contenu tombe2");
INSERT INTO PARAM_ITEM (ITEM_ID, ITEM_NAME, CAT_ID, USR_ID, ITEM_IMG_HEAD_URL, ITEM_COMMENTS, ITEM_CONTENT)
VALUES (3, "tombe3", 1, 1, "../../../../assets/images/imageTombe3.jpg", "La tombe 3 oulala", "Test de contenu tombe3");
INSERT INTO PARAM_ITEM (ITEM_ID, ITEM_NAME, CAT_ID, USR_ID, ITEM_IMG_HEAD_URL, ITEM_COMMENTS, ITEM_CONTENT)
VALUES (4, "temple1", 2, 1, "../../../../assets/images/imageTombe3.jpg", "Le temple 1 trop beau", "Test de contenu temple1");
INSERT INTO PARAM_ITEM (ITEM_ID, ITEM_NAME, CAT_ID, USR_ID, ITEM_IMG_HEAD_URL, ITEM_COMMENTS, ITEM_CONTENT)
VALUES (5, "temple2", 2, 1, "../../../../assets/images/imageTombe3.jpg", "Le temple 2 pas mal", "Test de contenu temple2");
INSERT INTO PARAM_ITEM (ITEM_ID, ITEM_NAME, CAT_ID, USR_ID, ITEM_IMG_HEAD_URL, ITEM_COMMENTS, ITEM_CONTENT)
VALUES (6, "temple3", 2, 1, "../../../../assets/images/imageTombe3.jpg", "Ah ? un temple3 ça ?", "Test de contenu temple3");
INSERT INTO PARAM_ITEM (ITEM_ID, ITEM_NAME, CAT_ID, USR_ID, ITEM_IMG_HEAD_URL, ITEM_COMMENTS, ITEM_CONTENT)
VALUES (7, "Divers1", 3, 1, "../../../../assets/images/imageTombe3.jpg", "Heu, quoi ça ?", "Test de contenu divers");
