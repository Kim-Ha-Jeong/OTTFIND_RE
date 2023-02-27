const SET_FILM = 'setFilm' as const;

export const setFILM = (find: boolean, data: object[]) => ({
  type: SET_FILM,
  find,
  data,
});

type state = {
  find: boolean;
  data: object[];
};

type setFilmAction = ReturnType<typeof setFILM>;

const initialState: state = {
  find: false,
  data: [],
};

const setFilm = (state: state = initialState, action: setFilmAction) => {
  switch (action.type) {
    case SET_FILM:
      return { ...state, find: action.find, data: action.data };
    default:
      return state;
  }
};

export default setFilm;
