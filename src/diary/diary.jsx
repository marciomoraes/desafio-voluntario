/* Arquivo principal de Students */
import React, { Component } from 'react';

import ContentHeader from '../common/template/contentHeader';
import Content from '../common/template/content';
import Grid from '../common/layout/grid';
import Row from '../common/layout/row';

class Diary extends Component {
  render() {
    return (
      <div>
        <ContentHeader title='Diáro da Sala' />
        <Content>
          <Row>
            <Grid cols='12 6'>(Diário da aula)</Grid>
          </Row>
        </Content>
      </div>
    )
  }
}

export default Diary;
