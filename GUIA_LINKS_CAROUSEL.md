# 🎯 Guia de Uso - Carrossel Automático e Links

## ✨ Melhorias Implementadas

### 1. **Carrossel Automático**
- ✅ O carrossel agora troca automaticamente a cada **3,5 segundos**
- ✅ Transição suave entre as imagens
- ✅ Continua infinitamente enquanto o app estiver aberto

### 2. **Links Clicáveis no Carrossel**
- ✅ Cada banner pode ter sua própria URL
- ✅ Ao clicar no banner, abre o link no navegador
- ✅ Feedback visual ao tocar (ripple effect)

### 3. **Links Clicáveis nos Destaques**
- ✅ Cada destaque pode ter sua própria URL
- ✅ Ao clicar no destaque, abre o link no navegador
- ✅ Animações suaves ao aparecer

### 4. **Melhorias Visuais**
- ✅ Cards mais modernos com cantos arredondados (16dp)
- ✅ Elevação aumentada (8dp) para melhor profundidade
- ✅ Gradiente sutil sobre as imagens dos destaques
- ✅ Animações de fade-in e slide-in
- ✅ Tamanhos otimizados dos cards

---

## 🔧 Como Personalizar as URLs

### **Carrossel (Banners)**

Abra o arquivo: `app/src/main/java/br/edu/ifsp/vidaif/fragment/HomeFragment.kt`

Procure pela função `setupBannerCarousel()` (linha ~51) e edite as URLs:

```kotlin
val banners = listOf(
    Banner(
        imageRes = R.drawable.banner1,
        url = "https://www.ifsp.edu.br"  // 👈 TROQUE AQUI pela URL desejada
    ),
    Banner(
        imageRes = R.drawable.banner2,
        url = "https://www.ifsp.edu.br/noticias"  // 👈 TROQUE AQUI
    ),
    Banner(
        imageRes = R.drawable.banner3,
        url = "https://www.ifsp.edu.br/processos-seletivos"  // 👈 TROQUE AQUI
    ),
    Banner(
        imageRes = R.drawable.banner4,
        url = "https://www.ifsp.edu.br/eventos"  // 👈 TROQUE AQUI
    ),
    Banner(
        imageRes = R.drawable.banner5,
        url = "https://www.ifsp.edu.br/cursos"  // 👈 TROQUE AQUI
    )
)
```

### **Destaques**

No mesmo arquivo `HomeFragment.kt`, procure pela função `setupDestaquesRecyclerView()` (linha ~109) e edite as URLs:

```kotlin
val destaques = listOf(
    Destaque(
        title = "Processo Seletivo Simplificado para Vagas dos Cursos de Extensão",
        imageRes = R.drawable.destaque1,
        url = "https://www.ifsp.edu.br/processos-seletivos"  // 👈 TROQUE AQUI
    ),
    Destaque(
        title = "IFSP abre concurso público com 21 vagas",
        imageRes = R.drawable.destaque2,
        url = "https://www.ifsp.edu.br/concursos"  // 👈 TROQUE AQUI
    ),
    Destaque(
        title = "Processo seletivo de professor substituto",
        imageRes = R.drawable.destaque3,
        url = "https://www.ifsp.edu.br/vagas"  // 👈 TROQUE AQUI
    )
)
```

---

## ⚙️ Configurações Avançadas

### Alterar Velocidade do Auto-Scroll

No arquivo `HomeFragment.kt`, procure pela função `startAutoScroll()` (linha ~87):

```kotlin
autoScrollHandler?.postDelayed(this, 3500) // 👈 3500 = 3,5 segundos
```

**Valores sugeridos:**
- `2000` = 2 segundos (rápido)
- `3500` = 3,5 segundos (padrão)
- `5000` = 5 segundos (lento)

### Desativar URLs (se quiser banners/destaques não clicáveis)

Para tornar um banner ou destaque não clicável, deixe a URL vazia:

```kotlin
Banner(
    imageRes = R.drawable.banner1,
    url = ""  // 👈 Deixe vazio para não ser clicável
)
```

---

## 📁 Arquivos Modificados

1. **Novos Modelos:**
   - `model/Banner.kt` - Modelo para banners com URL
   - `model/Destaque.kt` - Atualizado com campo URL

2. **Adapters Atualizados:**
   - `adapter/BannerAdapter.kt` - Suporte a cliques e animações
   - `adapter/DestaqueAdapter.kt` - Suporte a cliques e animações

3. **Fragment Atualizado:**
   - `fragment/HomeFragment.kt` - Auto-scroll e URLs

4. **Layouts Melhorados:**
   - `layout/item_banner.xml` - Visual modernizado
   - `layout/item_destaque.xml` - Visual modernizado

5. **Novos Recursos Visuais:**
   - `drawable/gradient_overlay.xml` - Gradiente sobre imagens
   - `drawable/ripple_effect.xml` - Efeito de clique

---

## 🎨 Melhorias Visuais Implementadas

### Carrossel (Banner):
- ✅ Altura aumentada: 180dp → 200dp
- ✅ Cantos arredondados: 12dp → 16dp
- ✅ Elevação: 4dp → 8dp
- ✅ Margens aumentadas para melhor espaçamento
- ✅ MaterialCardView para melhor visual

### Destaques:
- ✅ Tamanho do card: 260x160dp → 280x180dp
- ✅ Altura da imagem: 100dp → 120dp
- ✅ Cantos arredondados: 12dp → 16dp
- ✅ Elevação: 4dp → 8dp
- ✅ Gradiente sutil sobre imagens
- ✅ Espaçamento entre linhas do texto
- ✅ MaterialCardView para melhor visual

---

## 🚀 Como Testar

1. **Compile e execute o app**
2. **Vá para a Home**
3. **Observe:**
   - O carrossel trocando automaticamente
   - Toque em qualquer banner → Deve abrir o navegador
   - Toque em qualquer destaque → Deve abrir o navegador

---

## 💡 Dicas

- **URLs devem começar com `http://` ou `https://`**
- **Se uma URL não funcionar, verifique se está correta**
- **Para links internos do app, você pode implementar navegação entre telas (não implementado nesta versão)**

---

## 🐛 Resolução de Problemas

**Problema:** Auto-scroll não funciona
- **Solução:** Verifique se o HomeFragment está sendo destruído e recriado rapidamente

**Problema:** Links não abrem
- **Solução:** Verifique se as URLs estão corretas e começam com `http://` ou `https://`

**Problema:** Animações não aparecem
- **Solução:** Certifique-se de que os arquivos de animação em `/res/anim/` existem

---

## 📞 Suporte

Se tiver dúvidas ou precisar de mais personalizações, é só pedir! 😊
