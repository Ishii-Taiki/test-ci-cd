use training;

/* Drop Tables */

DROP TABLE IF EXISTS goods;
DROP TABLE IF EXISTS maker;
DROP TABLE IF EXISTS category;

commit;


/* Create Tables */


CREATE TABLE category (
	category_id int(4) NOT NULL AUTO_INCREMENT,
	category_name varchar(50) NOT NULL,
	PRIMARY KEY (category_id)
);

CREATE TABLE maker (
	maker_id int(4) NOT NULL AUTO_INCREMENT,
	maker_name varchar(50) NOT NULL,
	PRIMARY KEY (maker_id)
);

CREATE TABLE goods (
	goods_id int(4) NOT NULL AUTO_INCREMENT,
	goods_name varchar(50) NOT NULL,
	goods_tanka int(8) NOT NULL,
	category_id int(4),
	maker_id int(4),
	version int(18) NOT NULL,
	PRIMARY KEY (goods_id),
	FOREIGN KEY(category_id) REFERENCES category(category_id),
	FOREIGN KEY(maker_id) REFERENCES maker(maker_id)
);

INSERT INTO category VALUES(1,'お弁当');
INSERT INTO category VALUES(2,'ガム');
INSERT INTO category VALUES(3,'スナック');
INSERT INTO category VALUES(4,'飲料水');
INSERT INTO category VALUES(5,'生活用品');

INSERT INTO maker VALUES(1,'PB');
INSERT INTO maker VALUES(2,'代予木');
INSERT INTO maker VALUES(3,'近藤');
INSERT INTO maker VALUES(4,'コバヤシ');
INSERT INTO maker VALUES(5,'キリンドウ');
INSERT INTO maker VALUES(6,'四ツ谷');
INSERT INTO maker VALUES(7,'PIROK');
INSERT INTO maker VALUES(8,'SUNTORU 8');

INSERT INTO goods VALUES(1,'化粧水UV＋乳液',         1600,5,2,1);
INSERT INTO goods VALUES(2,'佐伯ちずのコットンパフ',  370,5,2,1);
INSERT INTO goods VALUES(3,'キリン天然水',            150,4,5,1);
INSERT INTO goods VALUES(4,'コカコーク',              160,4,5,1);
INSERT INTO goods VALUES(5,'キシリミントガム',        120,2,6,1);
INSERT INTO goods VALUES(6,'ナッツチップ',            180,3,1,1);
INSERT INTO goods VALUES(7,'鮭いくらのおにぎりセット',260,1,2,1);
INSERT INTO goods VALUES(8,'ダイエット幕の内',        650,1,1,1);
INSERT INTO goods VALUES(9,'ハンバーグチーズ焼き弁当',700,1,1,1);
INSERT INTO goods VALUES(10,'歯磨きセット',           450,5,2,1);
INSERT INTO goods VALUES(11,'ポテチ石垣塩',           210,3,1,1);
commit;


