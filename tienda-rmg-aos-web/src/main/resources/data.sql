-- ============================================================
-- DATOS INICIALES TIENDA RAWBEAN
-- PDF 7: cubrimos los 8 escenarios pedidos por el profe.
-- Orden de carga obligatorio:
--   1) categorias    (sin FKs)
--   2) marcas        (sin FKs)
--   3) productos     (FK obligatoria a marcas)
--   4) productos_categorias  (FKs a productos y categorias - tabla pivote del ManyToMany)
-- ============================================================


-- 1) CATEGORIAS ---------------------------------------------
-- (id 1) Arabica          -> varios productos  (escenario 8)
-- (id 2) Robusto          -> varios productos  (escenario 8)
-- (id 3) Tueste Claro     -> UN SOLO producto  (escenario 7)
-- (id 4) Tueste Oscuro    -> varios productos  (escenario 8)
-- (id 5) Edicion Limitada -> SIN productos     (escenario 6)
INSERT INTO categorias (nombre, descripcion, imagen, activo) VALUES ('Arábica', 'Cafés de variedad arábica, suaves y aromáticos, con buena acidez y notas dulces.', null, true);
INSERT INTO categorias (nombre, descripcion, imagen, activo) VALUES ('Robusto', 'Cafés de variedad robusta, intensos, con cuerpo y mayor cafeína.', null, true);
INSERT INTO categorias (nombre, descripcion, imagen, activo) VALUES ('Tueste Claro', 'Cafés con tueste claro que conservan los matices florales y cítricos del grano.', null, true);
INSERT INTO categorias (nombre, descripcion, imagen, activo) VALUES ('Tueste Oscuro', 'Cafés con tueste oscuro, intensos, con notas de chocolate y caramelo.', null, true);
INSERT INTO categorias (nombre, descripcion, imagen, activo) VALUES ('Edición Limitada', 'Series especiales y de tirada corta. De momento no tenemos productos en esta categoría.', null, true);


-- 2) MARCAS -------------------------------------------------
-- (id 1) CaféOrigen   -> varios productos
-- (id 2) Montaña Verde -> varios productos
-- (id 3) BaristaPro   -> varios productos
-- (id 4) TierraViva   -> varios productos
-- (id 5) IslandCoffee -> varios productos
-- (id 6) Nespresso    -> SIN productos (escenario 2)
INSERT INTO marcas (nombre, descripcion, imagen, activo) VALUES ('CaféOrigen', 'Marca propia de cafés de origen único. Trazabilidad de finca y tueste artesanal.', null, true);
INSERT INTO marcas (nombre, descripcion, imagen, activo) VALUES ('Montaña Verde', 'Marca enfocada en cafés sostenibles cultivados en altura.', null, true);
INSERT INTO marcas (nombre, descripcion, imagen, activo) VALUES ('BaristaPro', 'Mezclas y blends pensados para hostelería profesional.', null, true);
INSERT INTO marcas (nombre, descripcion, imagen, activo) VALUES ('TierraViva', 'Cafés ecológicos certificados, comercio justo y producción de pequeños agricultores.', null, true);
INSERT INTO marcas (nombre, descripcion, imagen, activo) VALUES ('IslandCoffee', 'Especialistas en cafés de islas y zonas volcánicas.', null, true);
INSERT INTO marcas (nombre, descripcion, imagen, activo) VALUES ('Nespresso', 'Marca internacional de cápsulas. De momento no vendemos productos suyos.', null, true);


-- 3) PRODUCTOS ----------------------------------------------
-- Cada producto tiene marca_id obligatoria (FK a marcas).
-- Los IDs se asignan secuencialmente al insertar (IDENTITY).
INSERT INTO productos (codigo_ean, nombre, marca_id, descripcion, imagen, precio, descuento) VALUES ('8410285004230', 'Café Arábica Etiopía', 1, 'Café de especialidad procedente de las tierras altas de Etiopía, cultivado a más de 1800 metros de altitud. Sus granos presentan notas florales intensas, con toques de jazmín y bergamota, acompañados de una acidez brillante y un dulzor natural que recuerda a los frutos rojos maduros. Ideal para métodos de extracción en frío o pour over.', '/images/productos/cafe.webp', 12.95, 0);
INSERT INTO productos (codigo_ean, nombre, marca_id, descripcion, imagen, precio, descuento) VALUES ('8410285004247', 'Café Robusta Uganda', 1, 'Robusta ugandés de gran cuerpo y elevado contenido en cafeína. Perfecto para espresso intenso.', '/images/productos/cafe.webp', 9.95, 10);
INSERT INTO productos (codigo_ean, nombre, marca_id, descripcion, imagen, precio, descuento) VALUES ('8410285004254', 'Café Tueste Claro Colombia', 2, 'Café colombiano con tueste claro que preserva todas las notas frutales y florales del grano. Cultivado en la región de Huila, presenta una taza limpia con acidez cítrica, notas de melocotón y un retrogusto dulce y prolongado. Recomendado para filtro o aeropress.', null, 11.50, 0);
INSERT INTO productos (codigo_ean, nombre, marca_id, descripcion, imagen, precio, descuento) VALUES ('8410285004261', 'Café Tueste Oscuro Brasil', 2, 'Tueste oscuro brasileño con notas de chocolate y caramelo.', null, 8.75, 0);
INSERT INTO productos (codigo_ean, nombre, marca_id, descripcion, imagen, precio, descuento) VALUES ('8410285004278', 'Café Guatemala Antigua', 1, 'Procedente de la región de Antigua en Guatemala, este café de tueste medio ofrece una taza equilibrada con notas de chocolate con leche, nuez moscada y una suave acidez. Su cultivo en suelos volcánicos le aporta una mineralidad característica que lo distingue de otros cafés centroamericanos.', '/images/productos/cafe.webp', 13.50, 15);
INSERT INTO productos (codigo_ean, nombre, marca_id, descripcion, imagen, precio, descuento) VALUES ('8410285004285', 'Café Kenya AA', 1, 'Café keniano de grado AA, el más alto en clasificación. Notas de grosella negra y tomate.', '/images/productos/cafe.webp', 14.95, 0);
INSERT INTO productos (codigo_ean, nombre, marca_id, descripcion, imagen, precio, descuento) VALUES ('8410285004292', 'Café Yemen Moka', 5, 'El legendario café de Yemen, considerado uno de los más antiguos del mundo. Su proceso de secado natural al sol le aporta una complejidad única, con notas de vino tinto, especias y cacao. Un café para los más aventureros y curiosos del mundo del café de especialidad.', null, 18.95, 0);
INSERT INTO productos (codigo_ean, nombre, marca_id, descripcion, imagen, precio, descuento) VALUES ('8410285004308', 'Café Vietnam Robusta', 3, 'Robusta vietnamita de sabor intenso y gran cuerpo. Una opción potente y económica.', null, 7.50, 5);
INSERT INTO productos (codigo_ean, nombre, marca_id, descripcion, imagen, precio, descuento) VALUES ('8410285004315', 'Blend Espresso Clásico', 3, 'Mezcla de arábica y robusta especialmente diseñada para espresso. Equilibrio perfecto entre cuerpo, crema y aroma. Una combinación de granos de Brasil, Colombia y Uganda que ofrece una taza con notas de avellana, chocolate negro y un final largo y persistente. La elección de los baristas profesionales.', '/images/productos/cafe.webp', 10.95, 20);
INSERT INTO productos (codigo_ean, nombre, marca_id, descripcion, imagen, precio, descuento) VALUES ('8410285004322', 'Café Descafeinado Colombia', 3, 'Descafeinado mediante proceso natural con agua, sin químicos. Conserva todo el sabor.', '/images/productos/cafe.webp', 10.50, 0);
INSERT INTO productos (codigo_ean, nombre, marca_id, descripcion, imagen, precio, descuento) VALUES ('8410285004339', 'Café Peru Orgánico', 4, 'Café orgánico certificado procedente de pequeños productores del norte de Perú. Cultivado sin pesticidas ni fertilizantes químicos, con prácticas de agricultura sostenible. Presenta notas de frutos secos, miel y un toque de canela con una acidez moderada y muy agradable.', null, 12.25, 0);
INSERT INTO productos (codigo_ean, nombre, marca_id, descripcion, imagen, precio, descuento) VALUES ('8410285004346', 'Café Bolivia Geisha', 4, 'Variedad geisha de Bolivia, escasa y muy apreciada por los catadores.', null, 22.95, 0);
INSERT INTO productos (codigo_ean, nombre, marca_id, descripcion, imagen, precio, descuento) VALUES ('8410285004353', 'Café Sumatra Mandheling', 5, 'El Sumatra Mandheling es uno de los cafés indonesios más reconocidos del mundo. Su proceso húmedo le confiere un cuerpo denso y aterciopelado, con notas de tierra, cedro, tabaco y un dulzor a chocolate oscuro. Bajo en acidez, ideal para quienes prefieren cafés con mucho cuerpo.', '/images/productos/cafe.webp', 13.75, 10);
INSERT INTO productos (codigo_ean, nombre, marca_id, descripcion, imagen, precio, descuento) VALUES ('8410285004360', 'Café Hawái Kona', 5, 'Café de las laderas del volcán Mauna Loa. Suave, aromático y muy escaso.', '/images/productos/cafe.webp', 29.95, 0);
INSERT INTO productos (codigo_ean, nombre, marca_id, descripcion, imagen, precio, descuento) VALUES ('8410285004377', 'Café Jamaica Blue Mountain', 5, 'El Jamaica Blue Mountain es considerado por muchos como el mejor café del mundo. Cultivado en las montañas Blue Mountain de Jamaica a más de 2000 metros, produce una taza extremadamente suave, sin amargor, con notas florales, cítricos y una dulzura natural excepcional.', '/images/productos/cafe.webp', 34.95, 0);
INSERT INTO productos (codigo_ean, nombre, marca_id, descripcion, imagen, precio, descuento) VALUES ('8410285004384', 'Café India Monzón Malabar', 5, 'Café sometido al proceso de monzón, que le da un sabor único y terroso.', null, 11.95, 5);
INSERT INTO productos (codigo_ean, nombre, marca_id, descripcion, imagen, precio, descuento) VALUES ('8410285004391', 'Café Nicaragua Matagalpa', 2, 'Café nicaragüense de la región de Matagalpa, con tueste medio y notas de caramelo, almendra y una acidez suave y redonda. Producido por cooperativas locales con comercio justo certificado, lo que garantiza condiciones dignas para los agricultores y sus familias.', '/images/productos/cafe.webp', 10.75, 0);
INSERT INTO productos (codigo_ean, nombre, marca_id, descripcion, imagen, precio, descuento) VALUES ('8410285004407', 'Café Costa Rica Tarrazú', 1, 'Costa Rica Tarrazú, uno de los cafés más equilibrados de Centroamérica.', null, 12.50, 0);
INSERT INTO productos (codigo_ean, nombre, marca_id, descripcion, imagen, precio, descuento) VALUES ('8410285004414', 'Blend Desayuno Intenso', 3, 'Mezcla de tueste oscuro pensada para el desayuno. Gran cuerpo y mucha cafeína para empezar el día con energía. Combina robusta de Uganda con arábica de Brasil en una proporción 60/40 que garantiza una crema densa y un sabor potente que aguanta bien la leche.', '/images/productos/cafe.webp', 8.95, 25);
INSERT INTO productos (codigo_ean, nombre, marca_id, descripcion, imagen, precio, descuento) VALUES ('8410285004421', 'Café Tanzania Peaberry', 1, 'El Peaberry es un grano especial que se forma cuando solo se desarrolla una semilla dentro de la cereza del café. El Tanzania Peaberry ofrece una concentración de sabores superior, con notas de ciruela, frambuesa y un final largo con toques de chocolate con leche.', '/images/productos/cafe.webp', 15.95, 0);


-- 4) PRODUCTOS_CATEGORIAS (tabla pivote del ManyToMany) ----
-- Productos sin categoria (escenario 3): 7 (Yemen Moka), 14 (Hawai Kona) -- no aparecen aqui.
-- Productos con 1 categoria (escenario 4) y con varias (escenario 5): se ven abajo.

-- Producto 1 (Etiopia) -> Arabica
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (1, 1);
-- Producto 2 (Uganda) -> Robusto
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (2, 2);
-- Producto 3 (Colombia) -> Arabica + Tueste Claro  (UNICO en Tueste Claro -> escenario 7)
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (3, 1);
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (3, 3);
-- Producto 4 (Brasil) -> Tueste Oscuro
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (4, 4);
-- Producto 5 (Guatemala) -> Arabica
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (5, 1);
-- Producto 6 (Kenya) -> Arabica
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (6, 1);
-- Producto 7 (Yemen Moka) -> NINGUNA categoria
-- Producto 8 (Vietnam) -> Robusto
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (8, 2);
-- Producto 9 (Blend Espresso) -> Arabica + Robusto + Tueste Oscuro
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (9, 1);
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (9, 2);
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (9, 4);
-- Producto 10 (Descafeinado Colombia) -> Arabica + Robusto
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (10, 1);
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (10, 2);
-- Producto 11 (Peru Organico) -> Arabica
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (11, 1);
-- Producto 12 (Bolivia Geisha) -> Arabica
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (12, 1);
-- Producto 13 (Sumatra Mandheling) -> Robusto + Tueste Oscuro
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (13, 2);
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (13, 4);
-- Producto 14 (Hawai Kona) -> NINGUNA categoria
-- Producto 15 (Jamaica Blue Mountain) -> Arabica
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (15, 1);
-- Producto 16 (India Monzon Malabar) -> Robusto
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (16, 2);
-- Producto 17 (Nicaragua Matagalpa) -> Arabica + Tueste Oscuro
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (17, 1);
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (17, 4);
-- Producto 18 (Costa Rica Tarrazu) -> Arabica
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (18, 1);
-- Producto 19 (Blend Desayuno Intenso) -> Robusto + Tueste Oscuro
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (19, 2);
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (19, 4);
-- Producto 20 (Tanzania Peaberry) -> Arabica
INSERT INTO productos_categorias (producto_id, categoria_id) VALUES (20, 1);
