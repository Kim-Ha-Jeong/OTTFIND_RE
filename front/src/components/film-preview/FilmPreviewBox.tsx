import styled from 'styled-components';
import { useSelector } from 'react-redux';

import { RootState } from '@/modules';

import FilmPreview from '@/components/film-preview/FilmPreview';
import None from '@/components/film-preview/None';
import More from '@/components/film-preview/More';

const FilmPreviewBox = ({ data, title }: PropsType) => {
  const film = useSelector((state: RootState) => state.setFilm);
  const films = data !== '' ? data : film.find ? film.data : '';

  return (
    <Wrapper>
      {films !== '' ? (
        films.map((ele: any, idx: number) => (
          <FilmPreview film={ele} key={idx} />
        ))
      ) : (
        <None />
      )}
      {film.find ? <More title={title} /> : ''}
    </Wrapper>
  );
};

type PropsType = {
  data: any;
  title: string;
};

const Wrapper = styled.div`
  width: 96%;
  margin: 2%;
`;

export default FilmPreviewBox;
