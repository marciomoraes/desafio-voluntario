/* Componente item de menu */
import React from 'react';

// componente funcional
export default props => (
  <li>
    <a href={props.path}>
      <i className={`fa fa-${props.icon}`}></i> {props.label}
    </a>
  </li>
)
