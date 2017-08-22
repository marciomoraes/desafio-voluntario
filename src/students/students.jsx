/* Arquivo principal de Students */
import React, { Component } from 'react';

import ContentHeader from '../common/template/contentHeader';
import Content from '../common/template/content';
import Grid from '../common/layout/grid';
import Row from '../common/layout/row';

class Students extends Component {
  render() {
    return (
      <div>
        <ContentHeader title='Alunos' />
        <Content>
          <Row>
            <Grid cols='12 6'>(Lista com todos os alunos)</Grid>
          </Row>
        </Content>
      </div>
    )
  }
}

export default Students;
