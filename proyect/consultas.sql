
INSERT INTO engine_type (id, name)
values (1, 'Gasolina')

INSERT INTO engine_type (id, name)
values (2, 'Diésel')

INSERT INTO engine_type (id, name)
values (3, 'Híbrido')

INSERT INTO engine_type (id, name)
values (4, 'Electrico')



INSERT INTO brands (id, name)
values (1, 'Toyota')

INSERT INTO brands (id, name)
values (2, 'Kia')

INSERT INTO brands (id, name)
values (3, 'Honda')

INSERT INTO brands (id, name)
values (4, 'Ford')

INSERT INTO brands (id, name)
values (5, 'Chevrolet')

INSERT INTO brands (id, name)
values (6, 'Hyundai')




INSERT INTO vehicle_type (id, name)
values (1, 'Sedan')

INSERT INTO vehicle_type (id, name)
values (2, 'Hatchback')

INSERT INTO vehicle_type (id, name)
values (3, 'SUV')

INSERT INTO vehicle_type (id, name)
values (4, 'Pickup')

INSERT INTO vehicle_type (id, name)
values (5, 'Fugoneta')




-- Tipos de reparaciones
INSERT INTO repair_type  (id, name, description)
values (1, 'Reparaciones del Sistema de Frenos', 'Incluye el reemplazo de pastillas de freno, discos, tambores, líneas de freno y reparación o reemplazo del cilindro maestro de frenos.')

INSERT into repair_type (id, name, description)
values (2, 'Servicio del Sistema de Refrigeración', 'Reparación o reemplazo de radiadores, bombas de agua, termostatos y mangueras, así como la solución de problemas de sobrecalentamiento.')

INSERT into repair_type (id, name, description)
values (3, 'Reparaciones del Motor', 'Desde reparaciones menores como el reemplazo de bujías y cables, hasta reparaciones mayores como la reconstrucción del motor o la reparación de la junta de la culata.')

INSERT into repair_type (id, name, description)
values (4, 'Reparaciones de la Transmisión', 'Incluyen la reparación o reemplazo de componentes de la transmisión manual o automática, cambios de líquido y solución de problemas de cambios de marcha.')

INSERT into repair_type (id, name, description)
values (5, 'Reparación del Sistema Eléctrico', 'Solución de problemas y reparación de alternadores, arrancadores, baterías y sistemas de cableado, así como la reparación de componentes eléctricos como faros, intermitentes y sistemas de entretenimiento.')

INSERT into repair_type (id, name, description)
values (6, 'Reparaciones del Sistema de Escape', 'Incluye el reemplazo del silenciador, tubos de escape, catalizador y la solución de problemas relacionados con las emisiones.')

INSERT into repair_type (id, name, description)
values (7, 'Reparación de Neumáticos y Ruedas', 'Reparación de pinchazos, reemplazo de neumáticos, alineación y balanceo de ruedas.')

INSERT into repair_type (id, name, description)
values (8, 'Reparaciones de la Suspensión y la Dirección', 'Reemplazo de amortiguadores, brazos de control, rótulas y reparación del sistema de dirección asistida.')

INSERT into repair_type (id, name, description)
values (9, 'Reparación del Sistema de Aire Acondicionado y Calefacción', 'Incluye la recarga de refrigerante, reparación o reemplazo del compresor, y solución de problemas del sistema de calefacción')

INSERT into repair_type (id, name, description)
values (10, 'Reparaciones del Sistema de Combustible', 'Limpieza o reemplazo de inyectores de combustible, reparación o reemplazo de la bomba de combustible y solución de problemas de suministro de combustible.')

INSERT into repair_type (id, name, description)
values (11, 'Reparación y Reemplazo del Parabrisas y Cristales', 'Reparación de pequeñas grietas en el parabrisas o reemplazo completo de parabrisas y ventanas dañadas.')

-- Precios de reparaciones

INSERT into price (id, id_repair_type, id_engine_type, price)
values (1, 1, 1, 120000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (2, 1, 2, 120000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (3, 1, 3, 180000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (4, 1, 4, 220000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (5, 2, 1, 130000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (6, 2, 2, 130000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (7, 2, 3, 190000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (8, 2, 4, 230000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (9, 3, 1, 350000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (10, 3, 2, 450000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (11, 3, 3, 700000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (12, 3, 4, 800000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (13, 4, 1, 210000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (14, 4, 2, 210000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (15, 4, 3, 300000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (16, 4, 4, 300000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (17, 5, 1, 150000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (18, 5, 2, 150000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (19, 5, 3, 200000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (20, 5, 4, 250000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (21, 6, 1, 100000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (22, 6, 2, 120000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (23, 6, 3, 450000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (24, 6, 4, 0)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (25, 7, 1, 100000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (26, 7, 2, 100000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (27, 7, 3, 100000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (28, 7, 4, 100000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (29, 8, 1, 180000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (30, 8, 2, 180000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (31, 8, 3, 210000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (32, 8, 4, 250000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (33, 9, 1, 150000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (34, 9, 2, 150000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (35, 9, 3, 180000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (36, 9, 4, 180000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (37, 10, 1, 130000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (38, 10, 2, 140000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (39, 10, 3, 220000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (40, 10, 4, 0)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (41, 11, 1, 80000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (42, 11, 2, 80000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (43, 11, 3, 80000)

INSERT into price (id, id_repair_type, id_engine_type, price)
values (44, 11, 4, 80000)

INSERT INTO discount_type (id, name) 
VALUES (1, 'Descuento por cantidad de reparaciones')

INSERT INTO discount_type (id, name)
VALUES (2, 'Descuento por día de atención')

INSERT INTO discount_type (id, name)
VALUES (3, 'Descuento por bonos')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (1, 5, 1, 1, '1-2')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (2, 10, 1, 1, '3-5')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (3, 15, 1, 1, '6-9')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (4, 20, 1, 1, '10+')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (5, 7, 1, 2, '1-2')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (6, 12, 1, 2, '3-5')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (7, 17, 1, 2, '6-9')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (8, 22, 1, 2, '10+')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (9, 10, 1, 3, '1-2')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (10, 15, 1, 3, '3-5')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (11, 20, 1, 3, '6-9')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (12, 25, 1, 3, '10+')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (13, 8, 1, 4, '1-2')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (14, 13, 1, 4, '3-5')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (15, 18, 1, 4, '6-9')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (16, 23, 1, 4, '10+')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (17, 10, 2, 1, 'lunes-9:00-12:00')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (18, 10, 2, 1, 'jueves-9:00-12:00')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (19, 10, 2, 2, 'lunes-9:00-12:00')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (20, 10, 2, 2, 'jueves-9:00-12:00')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (21, 10, 2, 3, 'lunes-9:00-12:00')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (22, 10, 2, 3, 'jueves-9:00-12:00')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (23, 10, 2, 4, 'lunes-9:00-12:00')

INSERT INTO discount (id, percentage, id_discount_type, id_engine_type, description)
VALUES (24, 10, 2, 4, 'jueves-9:00-12:00')


INSERT INTO surcharge_type (id, name)
VALUES (1, 'Recargo por kilometraje')

INSERT INTO surcharge_type (id, name)
VALUES (2, 'Recargo por antigüedad del vehículo')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (1, 0, 1, 1, '0-5000')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (2, 3, 1, 1, '5001-12000')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (3, 7, 1, 1, '12001-25000')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (4, 12, 1, 1, '25001-40000')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (5, 20, 1, 1, '40001+')


INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (6, 0, 1, 2, '0-5000')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (7, 3, 1, 2, '5001-12000')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (8, 7, 1, 2, '12001-25000')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (9, 12, 1, 2, '25001-40000')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (10, 20, 1, 2, '40001+')


INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (11, 0, 1, 3, '0-5000')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (12, 5, 1, 3, '5001-12000')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (13, 9, 1, 3, '12001-25000')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (14, 12, 1, 3, '25001-40000')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (15, 20, 1, 3, '40001+')


INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (16, 0, 1, 4, '0-5000')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (17, 5, 1, 4, '5001-12000')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (18, 9, 1, 4, '12001-25000')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (19, 12, 1, 4, '25001-40000')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (20, 20, 1, 4, '40001+')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (21, 0, 1, 5, '0-5000')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (22, 5, 1, 5, '5001-12000')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (23, 9, 1, 5, '12001-25000')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (24, 12, 1, 5, '25001-40000')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (25, 20, 1, 5, '40001+')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (26, 0, 2, 1, '0-5')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (27, 5, 2, 1, '6-10')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (28, 9, 2, 1, '11-15')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (29, 15, 2, 1, '16+')


INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (30, 0, 2, 2, '0-5')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (31, 5, 2, 2, '6-10')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (32, 9, 2, 2, '11-15')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (33, 15, 2, 2, '16+')


INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (34, 0, 2, 3, '0-5')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (35, 7, 2, 3, '6-10')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (36, 11, 2, 3, '11-15')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (37, 20, 2, 3, '16+')


INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (38, 0, 2, 4, '0-5')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (39, 7, 2, 4, '6-10')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (40, 11, 2, 4, '11-15')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (41, 20, 2, 4, '16+')


INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (42, 0, 2, 5, '0-5')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (43, 7, 2, 5, '6-10')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (44, 11, 2, 5, '11-15')

INSERT INTO surcharge (id, percentage, id_surcharge_type, id_vehicle_type, description)
VALUES (45, 20, 2, 5, '16+')