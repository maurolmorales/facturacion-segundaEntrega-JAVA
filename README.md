# Facturación Segunda Entrega

---

"Lista del Super" es una aplicación web PWA diseñada para ser utilizada en el celular. Permite a los usuarios generar una lista de artículos faltantes en el hogar, funcionando como una "lista del supermercado".

## Descripción

La aplicación se divide en dos partes:
1. **Inventario**: Los usuarios pueden generar una lista de artículos que comúnmente compran.
2. **Lista del Super**: A partir de la lista de inventario, los usuarios pueden generar una lista de productos a comprar. Los datos se guardan en las cookies del navegador.

**Nota**: La aplicación está en proceso de desarrollo y no está completamente terminada.

## Características

- Generación de una lista de inventario con artículos comúnmente comprados.
- Creación de una lista de productos a comprar basada en la lista de inventario.
- Control de artículos comprados mediante un botón de "check" en la lista del supermercado.

## Tecnologías Utilizadas

- **Frontend**: React.js, HTML, CSS, Tailwind
- **Backend**: Node.js, npm
- **Librerías**: React Router (react-router-dom)

## Instalación

Para clonar y ejecutar esta aplicación en tu máquina local, sigue estos pasos:

1. Clona el repositorio:

```bash
git clone https://github.com/mi-usuario/mi-repo.git
```

2. Navega al directorio del proyecto:

```bash
cd mi-repo`
```

3. Instala las dependencias:

```bash
cd site
npm install
```

4. Uso. Para ejecutar la aplicación, utiliza el siguiente comando:

```bash
npm run dev
```

Esto iniciará un servidor de desarrollo en un puerto local. Normalmente, puedes acceder a la aplicación en [link](http://localhost:3000).

## Funcionalidades:
Inventario:
Accede al ícono "Inventario" para generar la lista de artículos habituales.
Añade artículos a la lista del supermercado con el botón disponible en cada ítem.
Lista del Super:
Accede al ícono "Lista" para ver la lista generada a partir de la selección del usuario en el inventario.
Marca los artículos como comprados con el botón de "check" en cada ítem.
Contribuciones
Actualmente, no se aceptan contribuciones a este proyecto.